@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.safeArgs)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.neobischallengeandroidapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.neobischallengeandroidapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.navigationFragment)
    implementation(libs.navigation)
    implementation(libs.constraintlayout)

    implementation(libs.swiper)
    implementation(libs.viewmodel)
    implementation(libs.livedata)
    implementation(libs.runtime)
    implementation(libs.extensionsArg)
    implementation(libs.coroutineCore)
    implementation(libs.coroutineAndroid)
    implementation(libs.okhttp)
    implementation(libs.okhhtpInterceptor)
    implementation(libs.coil)
    implementation(libs.retrofite)
    implementation(libs.retrofiteAdapter)
    implementation(libs.retrofiteGson)
    implementation(libs.gson)
    implementation(libs.lottie)
    implementation(libs.materailsearchbar)
    implementation(libs.volley)
    implementation(libs.textTicker)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.49")
    kapt("com.google.dagger:hilt-android-compiler:2.49")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    //Room
    implementation("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    androidTestImplementation("androidx.room:room-testing:2.6.1")

}

kapt {
    correctErrorTypes = true
}
hilt {
    enableAggregatingTask = true
}