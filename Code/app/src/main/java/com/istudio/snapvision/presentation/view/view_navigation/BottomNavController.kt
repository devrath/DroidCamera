package com.istudio.snapvision.presentation.view.view_navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.istudio.core_navigation.NavigationRoute

@Composable
fun BottomNavigationController(
    selectedTabIndex: Int,
    navController: NavHostController
) {
    LaunchedEffect(selectedTabIndex) {
        // Change the Screen based on position
        // When we move to another screen -> Remove the previous screen
        if (selectedTabIndex == BottomNavItem.CaptureImageScreenPosition) {
            navController.navigate(NavigationRoute.CaptureImage.route) {
                popUpTo(NavigationRoute.RecordVideo.route) { inclusive = true }
            }
        } else if (selectedTabIndex == BottomNavItem.RecordVideoScreenPosition) {
            navController.navigate(NavigationRoute.RecordVideo.route) {
                popUpTo(NavigationRoute.CaptureImage.route) { inclusive = true }
            }
        }
    }
}