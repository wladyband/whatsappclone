
buildscript {
    dependencies {
        classpath ("com.google.gms:google-services:4.3.15")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.android.library") version "8.0.0" apply false
    id("com.google.dagger.hilt.android") version "2.42" apply false
    alias(libs.plugins.google.gms.google.services) apply false

}