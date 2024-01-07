plugins {
    id(ProjectConfig.commonPluginTag)
}

android {
    namespace = ProjectConfig.coreUi
}

dependencies {
    coreDependencies()
    compose()
    implementation(Dependencies.downloadableGoogleFonts)
}