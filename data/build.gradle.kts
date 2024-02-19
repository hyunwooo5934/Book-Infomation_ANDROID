plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = Dependency.NAMESPACE
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {

    implementation(project(mapOf("path" to ":domain")))

    implementation(Dependency.KTX.CORE_KTX)
    implementation(Dependency.AndroidX.APPCOMPAT)
    implementation(Dependency.Google.MATERIAL)
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ANDROIDX_TEST_JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ANDROIDX_ESPRESSO)

    //hilt
    implementation(Dependency.Hilt.HILT)
    kapt(Dependency.Hilt.HILT_CMOPILER)

    //retrofit2
    implementation (Dependency.Retrofit.RETROFIT) // retrofit2
    implementation (Dependency.Retrofit.RETROFIT_CONVERTER_GSON) // Gson 변환기

    // room database
    implementation (Dependency.Room.ROOM_KTX)
    implementation(Dependency.Room.ROOM_RUNTIME)
    kapt(Dependency.Room.ROOM_COMPILER)
}