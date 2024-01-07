plugins {
    id(ProjectConfig.commonPluginTag)
}

android {
    namespace = ProjectConfig.featureOnBoarding
}

dependencies {
    featureBase()
    lotteDependency()
    CORE_PREFERENCES
    CORE_UI
    CORE_COMMON
}