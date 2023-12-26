package com.istudio.core_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController

@Composable
fun NavGraph(navController: NavHostController) {
    // Define your navigation logic here
    /*NavHost(
        navController = navController,
        startDestination = NavigationRoute.CaptureImage.route
    ) {
        composable(route = Routes.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Routes.Details.route) {
            DetailsScreen(navController = navController)
        }
    }*/
}