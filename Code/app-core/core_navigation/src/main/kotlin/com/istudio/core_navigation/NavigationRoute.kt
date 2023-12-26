package com.istudio.core_navigation

sealed class NavigationRoute(val route: String) {
     object CaptureImage : NavigationRoute(route = "CaptureImage")
     object  RecordVideo : NavigationRoute(route = "RecordVideo")
}