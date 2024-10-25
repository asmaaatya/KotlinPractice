// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.5.1" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
//    id("com.google.devtools.ksp") version "2.0.0-1.0.22" apply false

    id("com.google.dagger.hilt.android") version "2.50" apply false
    // Kover plugin
    id("org.jetbrains.kotlinx.kover") version "0.7.6" apply false
}