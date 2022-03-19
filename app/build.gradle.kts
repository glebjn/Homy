plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.glebjay.homy"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.glebjay.homy"
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
    implementation(Deps.APPCOMPAT)
    implementation(Deps.CORE_KTX)
    implementation(Deps.MATERIAL)
    implementation(Deps.CONSTRAINT_LAYOUT)
    implementation(Deps.NAVIGATION_FRAGMENT_KTX)
    implementation(Deps.NAVIGATION_UI_KTX)
    implementation(Deps.COMPOSE_RUNTIME)
    androidTestImplementation(Deps.ANDROID_TEST_JUNIT_EXT)
    androidTestImplementation(Deps.EXPRESSO_CORE)
    testImplementation(Deps.JUNIT)
}