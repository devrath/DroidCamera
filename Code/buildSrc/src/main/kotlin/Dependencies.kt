import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    // Specific module links
    const val apiFactoryModuleLink = ":app-factories:api-factory"
    const val mockFactoryModuleLink = ":app-factories:fake-factory"

    // <-------------> Top level plugin Dependencies <-------------------->
    const val hiltProjectLevel = "com.google.dagger.hilt.android"
    const val junit5ProjectLevel = "de.mannodermaus.android-junit5"
    // <-------------> Top level plugin Dependencies <-------------------->

    const val javapoet = "com.squareup:javapoet:${Versions.javapoet}"

    // <---------------------> Core Dependencies <------------------------>
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutinesCore}"
    const val appcompact = "androidx.appcompat:appcompat:${Versions.appcompact}"
    const val activitycompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val coreMaterial = "com.google.android.material:material:${Versions.coreMaterial}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    const val serilization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serilization}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationUiKtx}"
    const val uiTextGoogleFonts = "androidx.compose.ui:ui-text-google-fonts:${Versions.uiTextGoogleFonts}"
    // <---------------------> Core Dependencies <------------------------>

    // <---------------------> Preference Dependencies <------------------>
    const val preferencesDataStore = "androidx.datastore:datastore-preferences:${Versions.datastorePreferences}"
    // <---------------------> Preference Dependencies <------------------>

    // <---------------------> Preference Dependencies <------------------>
    const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"
    // <---------------------> Preference Dependencies <------------------>

    // <---------------------> Preference Dependencies <------------------>
    const val coreSplash = "androidx.core:core-splashscreen:${Versions.coreSplash}"
    // <---------------------> Preference Dependencies <------------------>

    // <---------------------> Gson Dependencies <------------------------->
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    // <---------------------> Gson Dependencies <------------------------->

    // <---------------------> Compose Dependencies <--------------------->
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.materialIconsExtended}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    const val lifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleRuntimeCompose}"
    const val materialCompose = "androidx.compose.material:material:${Versions.materialCompose}"
    // <---------------------> Compose Dependencies <--------------------->

    // <---------------------> Hilt Dependencies <------------------------>
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    //const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    // <---------------------> Hilt Dependencies <------------------------>

    // <---------------------> OkHttp Dependencies <---------------------->
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    // <---------------------> OkHttp Dependencies <---------------------->

    // <---------------------> Retrofit Dependencies <-------------------->
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val kotlinxSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.kotlinxSerializationConverter}"
    const val kotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerializationJson}"
    const val retrofit2ConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2ConverterGson}"
    // <---------------------> Retrofit Dependencies <-------------------->

    // <---------------------> Room Dependencies <------------------------>
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    // <---------------------> Room Dependencies <------------------------>

    // <---------------------> UnitTest Dependencies <-------------------->
    const val junit = "junit:junit:${Versions.junit}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinxCoroutinesTestUnitTest}"
    const val mockServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockServer}"
    const val googleTruthLib = "com.google.truth:truth:${Versions.googleTruth}"
    const val testRunnerUnitTest = "androidx.test:runner:${Versions.testRunner}"
    // <---------------------> UnitTest Dependencies <-------------------->

    // <--------------> InstrumentationTest Dependencies <---------------->
    const val junitInstrumentation = "androidx.test.ext:junit:${Versions.junitInstrument}"
    const val testrules = "adroidx.test:rules:${Versions.testrules}"
    const val testCoreKtx = "androidx.test:core-ktx:${Versions.testCoreKtx}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    const val mockServerInstrumentation = "com.squareup.okhttp3:mockwebserver:${Versions.mockServer}"
    const val idlingResource = "com.jakewharton.espresso:okhttp3-idling-resource:${Versions.okhttp3IdlingResource}"
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    const val googleTruthLibInstrumentation = "com.google.truth:truth:${Versions.googleTruth}"
    const val kotlinxCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinxCoroutinesTestInstrumentationTest}"
    const val testRunnerInstrument= "androidx.test:runner:${Versions.testRunner}"
    // <--------------> InstrumentationTest Dependencies <---------------->

    // <--------------> Junit5 Dependencies <----------------------------->
    const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
    const val junitJupiterParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junit5}"
    const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"
    // <--------------> Junit5 Dependencies <----------------------------->

    // <--------------> MockK Dependencies <----------------------------->
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    const val mockkAgent = "io.mockk:mockk-agent:${Versions.mockk}"
    // <--------------> MockK Dependencies <----------------------------->

    // <--------------> MockK Server Dependencies <---------------------->
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
    // <--------------> MockK Server Dependencies <---------------------->

    // <-------------------> AssertK Dependencies <---------------------->
    const val assertK = "com.willowtreeapps.assertk:assertk:${Versions.assertK}"
    // <-------------------> AssertK Dependencies <---------------------->


    // <-------------------> CameraX Dependencies <---------------------->
    const val cameraCore = "androidx.camera:camera-core:${Versions.cameraxVersion}"
    const val cameraCamera2 = "androidx.camera:camera-camera2:${Versions.cameraxVersion}"
    const val cameraLifecycle = "androidx.camera:camera-lifecycle:${Versions.cameraxVersion}"
    const val cameraVideo = "androidx.camera:camera-video:${Versions.cameraxVersion}"
    const val cameraView = "androidx.camera:camera-view:${Versions.cameraxVersion}"
    const val cameraExtensions = "androidx.camera:camera-extensions:${Versions.cameraxVersion}"
    // <-------------------> CameraX Dependencies <---------------------->

}
// <----------- Individual Library group Dependencies ---------------->
// <--------> Core Dependencies <---------------->
fun DependencyHandler.coreDependencies() {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.activitycompose)
    implementation(Dependencies.appcompact)
    implementation(Dependencies.coreMaterial)
    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies.serilization)
    implementation(Dependencies.navigationUiKtx)
    implementation(Dependencies.uiTextGoogleFonts)
    hilt()
}

// <----------------> Junit5 <----------------------->
fun DependencyHandler.jUnit5() {
    testImplementation(Dependencies.junitJupiterApi)
    testImplementation(Dependencies.junitJupiterParams)
    androidTestImplementation(Dependencies.junitJupiterApi)
    androidTestImplementation(Dependencies.junitJupiterParams)
    testRuntimeOnly(Dependencies.junitJupiterEngine)
}

// <--------> Datastore Dependencies <---------------->
fun DependencyHandler.preferencesDataStore() {
    implementation(Dependencies.preferencesDataStore)
}
// <--------> Room Dependencies <---------------->
fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}
// <--------> Retrofit Dependencies <------------>
fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
    implementation(Dependencies.kotlinxSerializationConverter)
    implementation(Dependencies.kotlinxSerializationJson)
    implementation(Dependencies.retrofit2ConverterGson)
}
// <--------> Compose Dependencies <------------->
fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.materialIconsExtended)
    implementation(Dependencies.navigationCompose)
    implementation(Dependencies.lifecycleRuntimeCompose)
    implementation(Dependencies.materialCompose)
    implementation(Dependencies.hiltNavigationCompose)
    debugImplementation(Dependencies.composeUiToolingPreview)
}
// <---> Unit Testing Dependencies <---------------->
fun DependencyHandler.unitTesting() {
    // All Junit-5
    jUnit5()
    // other dependencies
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockitoKotlin)
    testImplementation(Dependencies.mockitoInline)
    testImplementation(Dependencies.mockitoCore)
    testImplementation(Dependencies.coreTesting)
    testImplementation(Dependencies.coroutinesTest)
    testImplementation(Dependencies.mockServer)
    testImplementation(Dependencies.googleTruthLib)
    testImplementation(Dependencies.googleTruthLib)
    testImplementation(Dependencies.testRunnerUnitTest)
    testImplementation(Dependencies.coreKtx)
    testImplementation(Dependencies.activitycompose)
    androidTestImplementation(Dependencies.turbine)
    testImplementation(Dependencies.mockkAndroid)
    testImplementation(Dependencies.mockkAgent)
    testImplementation(Dependencies.mockWebServer)
    testImplementation(Dependencies.assertK)
}
// <---> Instrumentation Testing Dependencies <----->
fun DependencyHandler.instrumentationTesting() {
    androidTestImplementation(Dependencies.junitInstrumentation)
    androidTestImplementation(Dependencies.turbine)
    androidTestImplementation(Dependencies.testCoreKtx)
    androidTestImplementation(Dependencies.espresso)
    androidTestImplementation(Dependencies.mockServerInstrumentation)
    androidTestImplementation(Dependencies.idlingResource)
    androidTestImplementation(Dependencies.hiltAndroidTesting)
    androidTestImplementation(Dependencies.googleTruthLibInstrumentation)
    androidTestImplementation(Dependencies.kotlinxCoroutinesTest)
    androidTestImplementation(Dependencies.testRunnerInstrument)
    androidTestImplementation(Dependencies.coreKtx)
    androidTestImplementation(Dependencies.activitycompose)
    androidTestImplementation(Dependencies.mockkAndroid)
    androidTestImplementation(Dependencies.mockkAgent)
    androidTestImplementation(Dependencies.mockWebServer)
    androidTestImplementation(Dependencies.assertK)
}
// <--------> Hilt Dependencies <------------------->
fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.cameraDependencies() {
    implementation(Dependencies.cameraCore)
    implementation(Dependencies.cameraCamera2)
    implementation(Dependencies.cameraLifecycle)
    implementation(Dependencies.cameraVideo)
    implementation(Dependencies.cameraView)
    implementation(Dependencies.cameraExtensions)
}
// <----------- Individual Library group Dependencies ---------------->



// <----------------- Root Module Dependencies ----------------------->
fun DependencyHandler.appModuleDependencies() {
    coreDependencies()
    implementation(Dependencies.coreSplash)
    compose()
    unitTesting()
    instrumentationTesting()
    common()
}

fun DependencyHandler.common() {
    coreDependencies()
    jUnit5()
    // --> Testing
    unitTesting()
    instrumentationTesting()
}



// <------------------------ Project Modules ------------------------>
fun DependencyHandler.featureCaptureImage() { implementation(project(":app-features:feature_camera")) }
fun DependencyHandler.featureRecordVideo() { implementation(project(":app-features:feature_gallery")) }
fun DependencyHandler.coreUi() { implementation(project(":app-core:core_ui")) }
fun DependencyHandler.coreCommon() { implementation(project(":app-core:core_common")) }
fun DependencyHandler.coreModels() { implementation(project(":app-core:core_models")) }
fun DependencyHandler.coreNavigation() { implementation(project(":app-core:core_navigation")) }
// <------------------------ Project Modules ------------------------>