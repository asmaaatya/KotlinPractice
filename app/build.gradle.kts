plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
//    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlinx.kover")
    id("kotlin-kapt")
    //get kapt plugin

}

android {
    namespace = "com.example.kotlinpractice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlinpractice"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        //com.emojitunes.emojis.EmojiTunesTestRunner
        //com.example.kotlinpractice

       testInstrumentationRunner =   "com.example.kotlinpractice.CustomTestRunner"
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "17"
    }
    configurations.all{
        resolutionStrategy.force("com.google.code.findbugs:jrs305:3.0.0")
    }

    buildFeatures {
        viewBinding = true
        dataBinding= true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")


    // hilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // okhttp
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // datastore
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    //view model
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    //nav controller
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.1")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.1")


    //kluentAndroid
    testImplementation ("org.amshove.kluent:kluent-android:1.73")
// For instrumented tests.
    // Hilt testing dependency
//    androidTestImplementation "com.google.dagger:hilt-android-testing:$hilt_version"
    // Make Hilt generate code in the androidTest folder
    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.44")
//    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:$2.44")
    kaptAndroidTest ("com.google.dagger:hilt-compiler:2.50")

    debugImplementation( "androidx.fragment:fragment-testing:1.8.2")
    implementation ("androidx.test:core:1.6.1")
    // Dependencies for Android instrumented unit tests
    androidTestImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // mockk
    testImplementation("io.mockk:mockk-android:1.13.11")
    testImplementation("io.mockk:mockk-agent:1.13.11")

    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    //turbine
    testImplementation("app.cash.turbine:turbine:1.1.0")
    // Mock web server
    testImplementation ("com.squareup.okhttp3:mockwebserver:4.10.0")
    // Google truth for assertion
    testImplementation ("com.google.truth:truth:1.1.3")
    androidTestImplementation ("org.robolectric:robolectric:4.10.3")

}
hilt {
    enableTransformForLocalTests = true
}