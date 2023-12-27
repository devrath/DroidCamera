package com.istudio.snapvision.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.istudio.core_navigation.NavGraph
import com.istudio.snapvision.presentation.view.utils.LaunchOncePerSession
import com.istudio.snapvision.presentation.view.utils.handleConfigurationEffect
import com.istudio.snapvision.ui.theme.CameraTheme
import dagger.hilt.android.AndroidEntryPoint


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
        // Nav controller
        val navController = rememberNavController()
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


    /** ************************************* PREVIEW  ***************************************/
    @Preview(showBackground = true)
    @Composable
    fun MainPreview() {
        initOnCreate()
    }
    /** ************************************* PREVIEW  ***************************************/

}