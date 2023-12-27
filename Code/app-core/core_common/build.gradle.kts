plugins {
    `android-library`
    `kotlin-android`
}

apply<plugins.FeaturesGradlePlugin>()

android {
    namespace = ProjectConfig.coreCommon
    kotlinOptions { ProjectConfig.jvmTarget }
}

dependencies {
    coreDependencies()
    implementation(Dependencies.gson)
}