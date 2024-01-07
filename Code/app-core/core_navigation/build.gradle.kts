plugins {
    id(ProjectConfig.commonPluginTag)
}

android {
    namespace = ProjectConfig.coreNavigation
}

dependencies {
    coreDependencies()
    compose()
    FEATURE_CAPTURE_IMAGE
    FEATURE_GALLERY
    FEATURE_ONBOARDING
}