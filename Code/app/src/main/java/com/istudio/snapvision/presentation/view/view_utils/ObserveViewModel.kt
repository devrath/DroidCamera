package com.istudio.snapvision.presentation.view.view_utils

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.istudio.snapvision.presentation.states.AppScreenResponseEvent
import com.istudio.snapvision.presentation.view.MainVm
import kotlinx.coroutines.launch

/**
 * Block is launched only once per session of the application
 */
@Composable
fun LaunchOncePerSession() {

    // View model reference
    val viewModel: MainVm = hiltViewModel()
    // View state reference from view model
    val state = viewModel.viewState

    // <!--------------------- CONTROLLERS ------------------------>
    // SnackBar controller
    val snackBarController = remember { SnackbarHostState() }
    // coroutine scope to handle co-routines
    val coroutineScope = rememberCoroutineScope()
    // <!--------------------- CONTROLLERS ------------------------>


    LaunchedEffect(key1 = state.launchedEffectState) {
        // <***********> Event is observed from View-Model <************>
        viewModel.uiEvent.collect { event ->
            when (event) {
                // ---> Display messages in snack-bar
                is AppScreenResponseEvent.ShowSnackBar -> {
                    coroutineScope.launch {
                        snackBarController.showSnackbar(message = event.message)
                    }
                }
            }
        }
        // <***********> Event is observed from View-Model <************>
    }
}