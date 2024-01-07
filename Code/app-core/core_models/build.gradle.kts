plugins {
    id(ProjectConfig.commonPluginTag)
}

android {
    namespace = ProjectConfig.coreModels
}

dependencies { coreDependencies() }