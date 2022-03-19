pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Homy"

include(":app")

fun includeFeature(name: String) {
    include(":${name}")
    project(":${name}").projectDir = File(rootDir, "modules/features/${name}")
}

includeFeature("feature-vitrina-api")
includeFeature("feature-vitrina-internal")

fun includeCore(name: String) {
    include(":${name}")
    project(":${name}").projectDir = File(rootDir, "modules/cores/${name}")
}
includeCore("core-domain")

