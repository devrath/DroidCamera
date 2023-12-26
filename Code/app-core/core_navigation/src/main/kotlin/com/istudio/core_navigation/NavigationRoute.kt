package com.istudio.core_navigation

sealed class NavigationRoute(val rout: String) {
     object  CaptureImage : NavigationRoute("CaptureImage")
     object  RecordVideo : NavigationRoute("RecordVideo")
}