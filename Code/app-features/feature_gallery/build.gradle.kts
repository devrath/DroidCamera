plugins {
    `android-library`
    `kotlin-android`
    id(Dependencies.junit5ProjectLevel) version Versions.junit5ProjectLevel
}

apply<plugins.FeaturesGradlePlugin>()

android {
    namespace = ProjectConfig.featureRecordVideo
    kotlinOptions { ProjectConfig.jvmTarget }
}

dependencies {
    coreDependencies()
    compose()
    testing()
}