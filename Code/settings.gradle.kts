pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SnapVision"
include(":app")
include(":app-features")
include(":app-features:feature-camera")
include(":app-core")
include(":app-core:core-ui")
include(":app-core:core-common")
include(":app-core:core-models")
