plugins {
    `android-library`
    `kotlin-android`
}

apply<plugins.FeaturesGradlePlugin>()

android {
    namespace = ProjectConfig.coreNavigation
    kotlinOptions { ProjectConfig.jvmTarget }
}

dependencies {
    coreDependencies()
    compose()
    featureCaptureImage()
    featureRecordVideo()
}