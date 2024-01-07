plugins {
    id("plugins.android-common")
}

android {
    namespace = ProjectConfig.featureCamera
    kotlinOptions { ProjectConfig.jvmTarget }
}

dependencies {
    featureBase()
    // Feature specific dependencies
    cameraDependencies()
}