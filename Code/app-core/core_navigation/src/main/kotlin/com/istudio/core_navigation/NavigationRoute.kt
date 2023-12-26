package com.istudio.core_navigation

sealed class NavigationRoute {
    object CaptureImage : NavigationRoute()
    object RecordVideo : NavigationRoute()
}