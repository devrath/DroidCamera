package com.istudio.core_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.istudio.feature_camera.presentation.ui.CaptureScreen
import com.istudio.feature_onboarding.presentation.ui.OnboardingScreen
import com.istudio.feature_record_video.presentation.ui.RecordVideoScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    // Define your navigation logic here
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.OnBoarding.route
    ) {
        composable(route = NavigationRoute.OnBoarding.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route = NavigationRoute.CaptureImage.route) {
            CaptureScreen(navController = navController)
        }
        composable(route = NavigationRoute.RecordVideo.route) {
            RecordVideoScreen(navController = navController)
        }
    }
}