object Dependency {

    const val NAMESPACE = "com.example.book"
    const val COMPILE_SDK = 34
    const val MIN_SDK = 24

    object KTX {
        const val CORE_KTX = "androidx.core:core-ktx:1.9.0"
    }

    object AndroidX {
        const val APPCOMPAT = "androidx.appcompat:appcompat:1.6.1"
        const val CONSTRAINTLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
        const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
        const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:2.5.3"
        const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:2.5.3"
    }

    object Test {
        const val JUNIT = "junit:junit:4.13.2"
    }

    object AndroidTest {
        const val ANDROIDX_TEST_JUNIT = "androidx.test.ext:junit:1.1.5"
        const val ANDROIDX_ESPRESSO = "androidx.test.espresso:espresso-core:3.5.1"
    }


    object Google {
        const val MATERIAL = "com.google.android.material:material:1.11.0"
    }

    object Retrofit {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
        const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:2.9.0"
    }

    object Hilt {
        const val HILT = "com.google.dagger:hilt-android:2.44"
        const val HILT_CMOPILER = "com.google.dagger:hilt-android-compiler:2.44"
    }

    object Room {
        private const val roomVersion = "2.4.1"
        const val ROOM_KTX = "androidx.room:room-ktx:$roomVersion"
        const val ROOM_RUNTIME = "androidx.room:room-runtime:$roomVersion"
        const val ROOM_COMPILER = "androidx.room:room-compiler:$roomVersion"

    }
}

