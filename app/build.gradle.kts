import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = 33
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.jfalstaff.currencycryptoapp"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes.onEach {
        val properties = Properties()
        properties.load(project.rootProject.file("apikey.properties").inputStream())
        val cryptoApiKey = properties.getProperty("CRYPTO_COMPARE_API_KEY", "")
        it.buildConfigField("String", "CRYPTO_COMPARE_API_KEY", cryptoApiKey)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=enable")
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation (Dependencies.KOTLIN_STD_LIB_DEP)
    implementation (Dependencies.CORE_KTX_DEP)
    implementation (Dependencies.APPCOMPAT_DEP)
    implementation (Dependencies.MATERIAL_DEP)
    implementation (Dependencies.CONSTRAINT_DEP)
    implementation (Dependencies.CARDVIEW_DEP)
    testImplementation (Dependencies.JUNIT_DEP)
    androidTestImplementation (Dependencies.JUNIT_ANDROID_DEP)
    androidTestImplementation (Dependencies.ESPRESSO_CORE_DEP)
    //Coroutines
    implementation (Dependencies.COROUTINES_CORE_DEP)
    implementation (Dependencies.COROUTINES_KOTLIN)
    //Retrofit
    implementation (Dependencies.RETROFIT_DEP)
    implementation (Dependencies.RETROFIT_CONVERTER_DEP)
    //Dagger
    implementation (Dependencies.DAGGER_DEP)
    kapt (Dependencies.DAGGER_COMPILER_DEP)
    // ViewModel
    implementation (Dependencies.VIEWMODEL_LIFECYCLE_KTX_DEP)
    // LiveData
    implementation (Dependencies.LIFECYCLE_LIVEDATA_KTX_DEP)
    implementation (Dependencies.LIFECYCLE_LIVEDATA_STREAM_KTX_DEP)
    //Room
    implementation(Dependencies.ROOM_RUNTIME_DEP)
    kapt(Dependencies.ROOM_RUNTIME_COMPILER_DEP)
    implementation(Dependencies.ROOM_KTX_DEP)
    //Picasso
    implementation (Dependencies.PICASSO_DEP)
    //WorkManager
    implementation (Dependencies.WORK_MANAGER_DEP)

    testImplementation (Dependencies.MOCKITO_CORE_DEP)
    testImplementation (Dependencies.MOCKITO_INLINE_DEP)
    testImplementation(Dependencies.MOCKITO_KOTLIN_DEP)
    testImplementation (Dependencies.ESPRESSO_INTENTS_DEP)
    debugImplementation (Dependencies.FRAGMENT_TESTING_DEP)
    debugImplementation (Dependencies.ESPRESSO_CONTRIB_DEP)
}