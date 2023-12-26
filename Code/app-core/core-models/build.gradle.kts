plugins {
    `android-library`
    `kotlin-android`
}

apply<plugins.FeaturesGradlePlugin>()

android {
    namespace = ProjectConfig.coreModels
    kotlinOptions { ProjectConfig.jvmTarget }
}

dependencies { coreDependencies() }