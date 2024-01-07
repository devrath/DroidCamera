import org.gradle.api.artifacts.dsl.Dependencies

plugins {
    `android-library`
    `kotlin-android`
    //id(Dependencies.junit5ProjectLevel) version Versions.junit5ProjectLevel
}

apply<plugins.FeaturesGradlePlugin>()

android {
    namespace = ProjectConfig.featureOnBoarding
    kotlinOptions { ProjectConfig.jvmTarget }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    coreDependencies()
    compose()
    testing()
}