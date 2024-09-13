plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("maven-publish")
}
android {
    namespace = "com.example.composelibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    publishing {
        multipleVariants {
            allVariants()
            withJavadocJar()
            withSourcesJar()
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeKotlinCompiler.get()
    }
}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("mavenRelease") {
                groupId = "com.github.timur200362"
                artifactId = "ComposeComponentsLibrary"
                version = "1.1.0"

                from(components["release"])
            }
            create<MavenPublication>("mavenDebug") {
                groupId = "com.github.timur200362"
                artifactId = "ComposeComponentsLibrary"
                version = "1.1.0"

                from(components["debug"])
            }
        }
    }
}
dependencies {
    implementation(libs.core.ktx)
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose)
    implementation(libs.compose.runtime)
    implementation(libs.compose.graphics)
    implementation(libs.compose.material.icons)
    implementation(libs.compose.tooling.preview)
    implementation(libs.compose.tooling)
    implementation(libs.compose.kotlin.compiler)
    implementation(libs.compose.material.icons.core)
    implementation(libs.material)
    implementation(libs.material3)
    implementation(libs.androidx.compose.material)
    implementation(libs.material3.android)
    implementation(libs.lifecycle.compose.compiler)

    implementation(libs.navigation.compose)

    implementation(libs.coil)
    implementation(libs.coil.svg)
    implementation(libs.coil.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
}