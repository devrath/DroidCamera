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
    const val coreUi = "com.istudio.core_ui"
    const val coreModels = "com.istudio.core_models"
    const val coreCommon = "com.istudio.core_common"
    const val coreNavigation = "com.istudio.core_navigation"
    const val featureCamera = "com.istudio.feature_capture_image"
    const val featureRecordVideo = "com.istudio.feature_record_video"


    //const val coreUi = "com.istudio.core_ui"
    // <---------> Namespaces <--------->

    // <---------> Test Instrumentaiton <--------->
    const val testInstrumentationRunner_AndroidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
    // <---------> Test Instrumentaiton <--------->

}