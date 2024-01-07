plugins {
    id("plugins.android-common")
}

android {
    namespace = ProjectConfig.corePreferences
}

dependencies { coreDependencies() }