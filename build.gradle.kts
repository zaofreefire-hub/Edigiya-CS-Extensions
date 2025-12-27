plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.cimaprovider"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.github.recloudstream:cloudstream:master-SNAPSHOT")
}
