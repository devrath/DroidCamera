plugins {
    id(ProjectConfig.commonPluginTag)
}

android {
    namespace = ProjectConfig.featureOnBoarding
}

dependencies {
    featureBase()
    CORE_PREFERENCES
}