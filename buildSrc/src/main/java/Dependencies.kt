object Sdk {
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 29
    const val COMPILE_SDK_VERSION = 29
}

object Versions {
    const val ANDROIDX_TEST_EXT = "1.1.1"
    const val ANDROIDX_TEST = "1.2.0"
    const val APPCOMPAT = "1.1.0"
    const val CONSTRAINT_LAYOUT = "2.0.0-beta8"
    const val CORE_KTX = "1.2.0"
    const val ESPRESSO_CORE = "3.2.0"
    const val JUNIT = "4.13"
    const val KTLINT = "0.37.2"
    const val HILT = "2.28-alpha"
    const val HILT_VIEWMODEL ="1.0.0-alpha01"
    const val RETROFIT = "2.9.0"
    const val RETROFIT_SERIAL_ADAPTER = "0.5.0"
    const val OKHTTP = "4.8.0"
    const val COIL = "0.11.0"
    const val LIVEDATAKTX = "2.2.0"
    const val VIEWMODELKTX = "2.2.0"
    const val NAVIGATION = "2.3.0"
    const val ROOM = "2.2.5"
    const val TIMBER = "4.7.1"
    const val MATERIAL = "1.3.0-alpha01"
    const val RECYCLER  = "1.1.0"
    const val RECYCLER_SELECTION = "1.1.0-rc01"
    const val KOTLIN_SERIALIZATION_PLUGIN = "0.20.0"
    const val PERMISSIONS_VER = "2.0.1"
    const val PHOTO_VIEW_VER = "2.3.0"
}

object BuildPluginsVersion {
    const val AGP = "4.0.1"
    const val DETEKT = "1.9.1"
    const val KOTLIN = "1.3.72"
    const val KTLINT = "9.2.1"
    const val VERSIONS_PLUGIN = "0.28.0"
    const val SERIALIZATION = "1.3.70"

}

object CoreLibs {
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val ANDROIDX_CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val ANDROIDX_NAV_RUNTIME_KTX = "androidx.navigation:navigation-runtime-ktx:${Versions.NAVIGATION}"
    const val ANDROIDX_NAV_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val ANDROIDX_NAV_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"

    const val TIMBER_LIB = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val MATERIAL_UI_LIB = "com.google.android.material:material:${Versions.MATERIAL}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER}"
    const val RECYCLER_VIEW_SELECTION = "androidx.recyclerview:recyclerview-selection:${Versions.RECYCLER_SELECTION}"
    const val EAZY_PERMISSIONS = "com.sagar:dslpermission:${Versions.PERMISSIONS_VER}"
}

object JetPackKTX {
    const val VIEWMODELSCOPE = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.VIEWMODELKTX}"
    const val LIFECYCLESCOPE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIVEDATAKTX}"
    const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIVEDATAKTX}"
}

object Navigation {
    const val NAVIGATION_COMP = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_DYNAMIC_FEATURE = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAVIGATION}"

}

object DILibs {
    const val HILT_DI = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_VIEWMODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_VIEWMODEL}"
    const val HILT_DI_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_DI_COMPILER_KAPT = "androidx.hilt:hilt-compiler:${Versions.HILT_VIEWMODEL}"
}

object NetLibs {
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGIN_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val KOTLIN_SERIALIZATION = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.KOTLIN_SERIALIZATION_PLUGIN}"
    const val SERIALIZATION_ADAPTER = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.RETROFIT_SERIAL_ADAPTER}"
}

object PhotoView {
    const val PHOTO_VIEW = "com.github.chrisbanes:PhotoView:${Versions.PHOTO_VIEW_VER}"
}

object CoilImageLib {
    const val COIL = "io.coil-kt:coil:${Versions.COIL}"
}

object RoomLib {
    const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"
}

object TestingLib {
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val ROOM_TESTING = "androidx.room:room-testing:${Versions.ROOM}"
}
object AndroidTestingLib {

    const val ANDROIDX_TEST_RULES = "androidx.test:rules:${Versions.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:${Versions.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_EXT_JUNIT = "androidx.test.ext:junit:${Versions.ANDROIDX_TEST_EXT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
    const val NAVIGATION_TEST = "androidx.navigation:navigation-testing:${Versions.NAVIGATION}"
}
