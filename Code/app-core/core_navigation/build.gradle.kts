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
    FEATURE_CAPTURE_IMAGE
    FEATURE_GALLERY
    FEATURE_ONBOARDING
}