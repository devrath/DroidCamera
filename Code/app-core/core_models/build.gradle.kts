plugins {
    id("plugins.android-common")
}

android {
    namespace = ProjectConfig.coreModels
}

dependencies { coreDependencies() }