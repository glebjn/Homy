buildscript {
    val compose_version by extra("1.1.0-rc01")
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.3.0-alpha01" apply false
    id("com.android.library") version "7.3.0-alpha01" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
}