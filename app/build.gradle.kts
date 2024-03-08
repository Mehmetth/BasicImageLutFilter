plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    namespace = "com.mehmetpetek.basicimagelutfilter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mehmetpetek.basicimagelutfilter"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    productFlavors {
        create("google") {
            dimension = "platform"
        }
        create("live") {
            dimension = "env"
            applicationId = "com.mehmetpetek.basicimagelutfilter"
            resValue("string", "app_name", "BasicImageLutFilter")
        }
        create("dev") {
            dimension = "env"
            applicationId = "com.mehmetpetek.basicimagelutfilter.beta"
            resValue("string", "app_name", "BasicImageLutFilter - BETA")
        }
    }
    flavorDimensions += listOf("platform", "env")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material3.windowSizeClass)

    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.lifecycle.runtimeCompose)

    lintChecks(libs.lint.checks)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.gson.google)

    implementation(libs.accompanist.navigation.animation)

    implementation(libs.coil.kt.compose)
}