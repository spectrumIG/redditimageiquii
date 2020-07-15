plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    kotlin("kapt")
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
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

    implementation(CoilImageLib.COIL)



    kapt(DILibs.HILT_DI_COMPILER)

    testImplementation(TestingLib.JUNIT)

    androidTestImplementation(AndroidTestingLib.ANDROIDX_TEST_EXT_JUNIT)
    androidTestImplementation(AndroidTestingLib.ANDROIDX_TEST_RULES)
    androidTestImplementation(AndroidTestingLib.ESPRESSO_CORE)
    androidTestImplementation(Navigation.NAVIGATION_TEST)
}
