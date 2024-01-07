plugins {
    id(ProjectConfig.commonPluginTag)
}

android {
    namespace = ProjectConfig.coreCommon
}

dependencies {
    coreDependencies()
    implementation(Dependencies.gson)
}