plugins {
    id("plugins.android-common")
}

android {
    namespace = ProjectConfig.coreUi
}

dependencies {
    coreDependencies()
    compose()
}