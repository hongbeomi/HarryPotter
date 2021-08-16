package dependencies

object Versions {
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0"
    const val buildTools = "29.0.3"
}

object Dep {

    const val androidGradlePlugin = "com.android.tools.build:gradle:4.1.0"

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.6.0"
        const val appcompat = "androidx.appcompat:appcompat:1.3.0"
        const val material = "com.google.android.material:material:1.4.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
        const val cardView = "androidx.cardview:cardview:1.0.0"

        object Lifecycle {
            private const val version = "2.2.0"

            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
        }
    }

    object Kotlin {
        private const val version = "1.4.10"

        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.2"
    }

    object Koin {
        private const val version = "2.0.1"

        const val koinAndroid = "org.koin:koin-android:$version"
        const val koinViewModel = "org.koin:koin-android-viewmodel:$version"
    }

    object Lottie {
        const val lottieAndroid = "com.airbnb.android:lottie:3.4.0"
    }

    object DiscreteScrollView {
        const val scrollView = "com.yarolegovich:discrete-scrollview:1.4.9"
    }

    object Retrofit2 {
        private const val version = "2.6.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp3 {
        private const val version = "4.9.1"
        const val okHttp = "com.squareup.okhttp3:okhttp:$version"
        const val urlConnection = "com.squareup.okhttp3:okhttp-urlconnection:$version"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Glide {
        private const val version = "4.11.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    object MaterialDialog {
        const val core = "com.afollestad.material-dialogs:core:3.3.0"
    }

    object Test {
        const val junit = "junit:junit:4.+"
        const val junitExt = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }

}
