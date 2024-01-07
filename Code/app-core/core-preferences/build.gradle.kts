plugins {
    `android-library`
    `kotlin-android`
}

apply<plugins.FeaturesGradlePlugin>()

android {
    namespace = ProjectConfig.corePreferences
    kotlinOptions { ProjectConfig.jvmTarget }
}

dependencies { coreDependencies() }