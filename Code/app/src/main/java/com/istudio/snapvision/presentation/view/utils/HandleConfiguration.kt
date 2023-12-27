package com.istudio.snapvision.presentation.view.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import com.istudio.snapvision.presentation.states.AppScreenViewEvent
import com.istudio.snapvision.presentation.view.MainVm

/**
 * Handle configuration of the screen
 */
@Composable
fun handleConfigurationEffect() {

    // Configuration Manager
    val configuration = LocalConfiguration.current
    // View model reference
    val viewModel: MainVm = hiltViewModel()

    LaunchedEffect(configuration) {
        // Save any changes to the orientation value on the configuration object
        // Snapshot Flow:-> used to calculate the difference between previos and current state using the flows
        snapshotFlow {
            configuration.orientation
        }.collect {
            // Update configuration to mutable view state so that composable can display appropriate screen modes
            viewModel.onEvent(AppScreenViewEvent.SetScreenOrientation(it))
        }
    }
}