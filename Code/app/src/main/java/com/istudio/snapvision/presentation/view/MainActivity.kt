package com.istudio.snapvision.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.istudio.core_navigation.NavGraph
import com.istudio.snapvision.presentation.states.AppScreenResponseEvent
import com.istudio.snapvision.presentation.states.AppScreenViewEvent
import com.istudio.snapvision.ui.theme.CameraTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent { initOnCreate() }
    }

    /** ************************************* Init Methods  ***************************************/
    /** <*******> Init OnCreate <******> **/
    @Composable
    private fun initOnCreate() {
        // View model reference
        val viewModel: MainVm = hiltViewModel()
        // View state reference from view model
        val state = viewModel.viewState

        // <!--------------------- CONTROLLERS ------------------------>
        // SnackBar controller
        val snackBarController = remember { SnackbarHostState() }
        // coroutine scope to handle co-routines
        val coroutineScope = rememberCoroutineScope()
        // Nav controller
        val navController = rememberNavController()
        // Focus Manager
        val focusManager = LocalFocusManager.current
        // Keyboard Manager
        val keyboardController = LocalSoftwareKeyboardController.current
        // <!--------------------- CONTROLLERS ------------------------>

        // --> This is used to update the Orientation
        handleConfigurationEffect()
        // --> Launch only once per session
        LaunchOncePerSession()

        CameraTheme(darkTheme = viewModel.currentTheme.value) {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                ) { innerPaddingModifier ->
                    NavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPaddingModifier)
                    )
                }
            }
        }
    }

    /** ************************************* Init Methods  ***************************************/

    /**
     * Handle configuration of the screen
     */
    @Composable
    private fun handleConfigurationEffect() {

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

    /**
     * Block is launched only once per session of the application
     */
    @Composable
    private fun LaunchOncePerSession() {

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

    /** ************************************* PREVIEW  ***************************************/
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        initOnCreate()
    }
    /** ************************************* PREVIEW  ***************************************/

}