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
include(":app-features:feature_camera")
include(":app-core")
include(":app-core:core_ui")
include(":app-core:core_common")
include(":app-core:core_models")
include(":app-features:feature_gallery")
include(":app-core:core_navigation")
