plugins {
    id("plugins.android-common")
}

android {
    namespace = ProjectConfig.featureRecordVideo
    kotlinOptions { ProjectConfig.jvmTarget }
}

dependencies {
    featureBase()
}