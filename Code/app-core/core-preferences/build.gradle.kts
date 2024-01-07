plugins {
    id(ProjectConfig.commonPluginTag)
}

android {
    namespace = ProjectConfig.corePreferences
}

dependencies { coreDependencies() }