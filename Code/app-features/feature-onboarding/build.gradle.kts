plugins {
    id("plugins.android-common")
}

android {
    namespace = ProjectConfig.featureOnBoarding
    kotlinOptions { ProjectConfig.jvmTarget }
}

dependencies {
    featureBase()
}