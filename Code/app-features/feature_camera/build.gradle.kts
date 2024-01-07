plugins {
    `android-library`
    `kotlin-android`
    id(Dependencies.junit5ProjectLevel) version Versions.junit5ProjectLevel
}

apply<plugins.FeaturesGradlePlugin>()

android {
    namespace = ProjectConfig.featureCamera
    kotlinOptions { ProjectConfig.jvmTarget }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    coreDependencies()
    compose()
    testing()
    // Feature specific dependencies
    cameraDependencies()
}