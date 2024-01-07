plugins {
    id("plugins.android-common")
}

android {
    namespace = ProjectConfig.featureCamera
}

dependencies {
    featureBase()
    // Feature specific dependencies
    cameraDependencies()
}