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
    }
}

dependencies {
    implementation(Deps.CORE_KTX)
    implementation(Deps.APPCOMPAT)
    implementation(Deps.MATERIAL)
    implementation(Deps.CONSTRAINT_LAYOUT)
    androidTestImplementation(Deps.ANDROID_TEST_JUNIT_EXT)
    androidTestImplementation(Deps.EXPRESSO_CORE)
    testImplementation(Deps.JUNIT)
}