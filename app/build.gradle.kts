plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = Dependency.NAMESPACE
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.book"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }


    buildFeatures {
        dataBinding = true
        viewBinding = true
        compose = true
    }


    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }



}

dependencies {

    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":domain")))

//    implementation ("androidx.core:core-ktx:1.9.0")

    implementation(Dependency.KTX.CORE_KTX)
    implementation(Dependency.AndroidX.APPCOMPAT)
    implementation(Dependency.Google.MATERIAL)
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ANDROIDX_TEST_JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ANDROIDX_ESPRESSO)


    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.compose.ui:ui-unit-android:1.5.4")
    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.9")



    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation ("androidx.activity:activity-ktx:1.4.0")

    implementation (Dependency.Retrofit.RETROFIT) // retrofit2
    implementation (Dependency.Retrofit.RETROFIT_CONVERTER_GSON) // Gson 변환기
    implementation ("com.squareup.okhttp3:logging-interceptor:4.5.0")

    //hilt
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation(Dependency.Hilt.HILT)
    kapt(Dependency.Hilt.HILT_CMOPILER)

    implementation ("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")

    // room database
    implementation (Dependency.Room.ROOM_KTX)
    implementation(Dependency.Room.ROOM_RUNTIME)
    kapt(Dependency.Room.ROOM_COMPILER)


    // compose
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.04.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation ("androidx.compose.runtime:runtime-livedata:1.3.3")
    implementation ("com.google.accompanist:accompanist-coil:0.13.0")
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.17.0")
    implementation ("androidx.navigation:navigation-compose:2.5.3")


    //Gilde
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    implementation ("com.github.skydoves:landscapist-glide:1.4.7")

}

kapt {
    correctErrorTypes = true
}