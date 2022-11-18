object Versions {
    const val coreKtxVersion = "1.7.0"
    const val kotlinStdLibVersion = "1.6.10"
    const val appcompatVersion = "1.4.1"
    const val materialVersion = "1.6.0"
    const val constraintLayoutVersion = "2.1.4"
    const val cardViewVersion = "1.0.0"
    const val junitVersion = "4.13.2"
    const val junitAndroidTestVersion = "1.1.3"
    const val espressoVersion = "3.4.0"
    const val coroutinesCoreVersion = "1.5.1"
    const val coroutinesAndroidVersion = "1.5.1"
    const val retrofit2Version = "2.9.0"
    const val retrofitConverterVersion = "2.9.0"
    const val daggerVersion = "2.40"
    const val daggerKaptCompilerVersion = "2.37"
    const val lifecycleViewModelVersion = "2.4.1"
    const val lifecycleLivedataVersion = "2.4.1"
    const val lifecycleLivedataStreamVersion = "2.4.1"
    const val roomVersion = "2.3.0"
    const val picassoVersion = "2.71828"
    const val workManagerVersion = "2.7.1"
    const val mockitoCoreVersion = "4.1.0"
    const val mockitoInlineVersion = "4.1.0"
    const val mockitoKotlinVersion = "1.5.0"
    const val fragmentDebugTestingVersion = "1.5.0"
}

object Dependencies {
    const val KOTLIN_STD_LIB_DEP =
        "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStdLibVersion}"
    const val CORE_KTX_DEP = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val APPCOMPAT_DEP = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val MATERIAL_DEP = "com.google.android.material:material:${Versions.materialVersion}"
    const val CONSTRAINT_DEP =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val CARDVIEW_DEP = "androidx.cardview:cardview:${Versions.cardViewVersion}"
    const val JUNIT_DEP = "junit:junit:${Versions.junitVersion}"
    const val JUNIT_ANDROID_DEP = "androidx.test.ext:junit:${Versions.junitAndroidTestVersion}"
    const val ESPRESSO_CORE_DEP = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"

    //Coroutines
    const val COROUTINES_CORE_DEP =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCoreVersion}"
    const val COROUTINES_KOTLIN =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroidVersion}"

    //Retrofit
    const val RETROFIT_DEP = "com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}"
    const val RETROFIT_CONVERTER_DEP =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitConverterVersion}"

    //Dagger
    const val DAGGER_DEP = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val DAGGER_COMPILER_DEP =
        "com.google.dagger:dagger-compiler:${Versions.daggerKaptCompilerVersion}"

    // ViewModel
    const val VIEWMODEL_LIFECYCLE_KTX_DEP =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelVersion}"

    // LiveData
    const val LIFECYCLE_LIVEDATA_KTX_DEP =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLivedataVersion}"
    const val LIFECYCLE_LIVEDATA_STREAM_KTX_DEP =
        "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifecycleLivedataStreamVersion}"

    //Room
    const val ROOM_RUNTIME_DEP = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val ROOM_RUNTIME_COMPILER_DEP = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val ROOM_KTX_DEP = "androidx.room:room-ktx:${Versions.roomVersion}"

    //Picasso
    const val PICASSO_DEP = "com.squareup.picasso:picasso:${Versions.picassoVersion}"

    //WorkManager
    const val WORK_MANAGER_DEP = "androidx.work:work-runtime-ktx:${Versions.workManagerVersion}"

    //Mockito and espresso
    const val MOCKITO_CORE_DEP = "org.mockito:mockito-core:${Versions.mockitoCoreVersion}"
    const val MOCKITO_INLINE_DEP = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"
    const val MOCKITO_KOTLIN_DEP = "com.nhaarman:mockito-kotlin:${Versions.mockitoKotlinVersion}"
    const val ESPRESSO_INTENTS_DEP =
        "androidx.test.espresso:espresso-intents:${Versions.espressoVersion}"
    const val FRAGMENT_TESTING_DEP =
        "androidx.fragment:fragment-testing:${Versions.fragmentDebugTestingVersion}"
    const val ESPRESSO_CONTRIB_DEP =
        "androidx.test.espresso:espresso-contrib:${Versions.espressoVersion}"
}