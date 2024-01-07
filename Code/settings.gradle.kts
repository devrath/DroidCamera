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
include(":app-core")
include(":app-features")
include(":app-core:core_ui")
include(":app-core:core_common")
include(":app-core:core_models")
include(":app-core:core-preferences")
include(":app-core:core_navigation")
include(":app-features:feature_camera")
include(":app-features:feature_gallery")
include(":app-features:feature-onboarding")
