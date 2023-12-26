import org.gradle.api.JavaVersion

object ProjectConfig {

    const val minSdk = 24
    const val compileSdk = 34
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0"
    // <---------> Java Version <--------->
    const val jvmTarget = "18"
    val javaVersion = JavaVersion.VERSION_18
    // <---------> Java Version <--------->

    // <---------> Namespaces <--------->
    const val appId = "com.istudio.snapvision"
    const val featureCamera = "com.istudio.feature_camera"
    //const val coreUi = "com.istudio.core_ui"
    // <---------> Namespaces <--------->

    // <---------> Test Instrumentaiton <--------->
    const val testInstrumentationRunner_AndroidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
    // <---------> Test Instrumentaiton <--------->

}