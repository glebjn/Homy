plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions.jvmTarget = "1.8"

    buildFeatures {
        android.buildFeatures.viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {
    implementation(project(":core-domain"))
    implementation(Deps.CORE_KTX)
    implementation(Deps.APPCOMPAT)
    implementation(Deps.MATERIAL)
    implementation(Deps.CONSTRAINT_LAYOUT)

    implementation(Deps.KOIN_ANDROID)
    implementation(Deps.KOIN_ANDROID_COMPAT)

    implementation(Deps.VIEWMODEL)
    implementation(Deps.KOTLIN_COROUTINE_ANDROID)

    implementation(Deps.COMPOSE_ACTIVITY)
    implementation(Deps.COMPOSE_ANIMATION)
    implementation(Deps.COMPOSE_VIEWMODEL)
    implementation(Deps.COMPOSE_UI_TOOLING)
    implementation(Deps.COMPOSE_MATERIAL)
    implementation(Deps.COMPOSE_RUNTIME)
    androidTestImplementation(Deps.COMPOSE_UI_TEST)

    testImplementation(Deps.MOCKK)
    testImplementation(Deps.KOTLIN_ASSERT)
    testImplementation(Deps.KOTLIN_COROUTINE_CORE)
    testImplementation(Deps.KOTLIN_COROUTINE_TEST)
}
