plugins {
    id("plugins.android-common")
}

android {
    namespace = ProjectConfig.coreCommon
}

dependencies {
    coreDependencies()
    implementation(Dependencies.gson)
}