plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdkVersion(Sdk.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(Sdk.MIN_SDK_VERSION)
        targetSdkVersion(Sdk.TARGET_SDK_VERSION)

        applicationId = AppCoordinates.APP_ID
        versionCode = AppCoordinates.APP_VERSION_CODE
        versionName = AppCoordinates.APP_VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
//        dataBinding = true
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")

    implementation(project(":library-android"))
    implementation(project(":library-kotlin"))

    implementation(CoreLibs.ANDROIDX_APPCOMPAT)
    implementation(CoreLibs.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(CoreLibs.ANDROIDX_CORE_KTX)
    implementation(CoreLibs.ANDROIDX_NAV_FRAGMENT_KTX)
    implementation(CoreLibs.ANDROIDX_NAV_RUNTIME_KTX)
    implementation(CoreLibs.ANDROIDX_NAV_UI_KTX)
    implementation(DILibs.HILT_DI)

    implementation(NetLibs.OKHTTP)
    implementation(NetLibs.RETROFIT)
    implementation(NetLibs.SERIALIZATION_ADAPTER)

    implementation(JetPackKTX.LIVEDATA)
    implementation(JetPackKTX.LIFECYCLESCOPE)
    implementation(JetPackKTX.VIEWMODELSCOPE)

    implementation(Navigation.NAVIGATION_COMP)
    implementation(Navigation.NAVIGATION_DYNAMIC_FEATURE)
    implementation(Navigation.NAVIGATION_UI)

    implementation(CoreLibs.TIMBER_LIB)
    implementation(CoilImageLib.COIL)

//    implementation(RoomLib.ROOM)
//    implementation(RoomLib.ROOM_KTX)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    kapt(DILibs.HILT_DI_COMPILER)
//    kapt(RoomLib.ROOM_COMPILER)

    testImplementation(TestingLib.JUNIT)
    testImplementation(TestingLib.ROOM_TESTING)

    androidTestImplementation(AndroidTestingLib.ANDROIDX_TEST_EXT_JUNIT)
    androidTestImplementation(AndroidTestingLib.ANDROIDX_TEST_RULES)
    androidTestImplementation(AndroidTestingLib.ESPRESSO_CORE)
    androidTestImplementation(AndroidTestingLib.NAVIGATION_TEST)
}
