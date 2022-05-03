plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.glebjay.designsystem"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.glebjay.designsystem"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Deps.CORE_KTX)
    implementation(Deps.KOIN_CORE)
    implementation(Deps.KOIN_ANDROID)
    implementation(Deps.KOIN_COMPOSE)
    implementation(Deps.COMPOSE_ACTIVITY)
    implementation(Deps.COMPOSE_ANIMATION)
    implementation(Deps.COMPOSE_VIEWMODEL)
    implementation(Deps.COMPOSE_UI_TOOLING)
    implementation(Deps.COMPOSE_MATERIAL)
    implementation(Deps.COMPOSE_RUNTIME)
    androidTestImplementation(Deps.COMPOSE_UI_TEST)
}