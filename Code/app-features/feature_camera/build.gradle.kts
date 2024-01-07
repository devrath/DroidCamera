plugins {
    id(ProjectConfig.commonPluginTag)
}

android {
    namespace = ProjectConfig.featureCamera
}

dependencies {
    featureBase()
    // Feature specific dependencies
    cameraDependencies()
}