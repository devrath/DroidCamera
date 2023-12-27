package com.istudio.snapvision.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.istudio.core_navigation.NavGraph
import com.istudio.snapvision.presentation.view.view_navigation.BottomNavItem
import com.istudio.snapvision.presentation.view.view_navigation.BottomNavRow
import com.istudio.snapvision.presentation.view.view_navigation.BottomNavigationController
import com.istudio.snapvision.presentation.view.view_utils.LaunchOncePerSession
import com.istudio.snapvision.presentation.view.view_utils.handleConfigurationEffect
import com.istudio.snapvision.ui.theme.CameraTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent { InitOnCreate() }
    }

    /** ************************************* Init Methods  ***************************************/
    /** <*******> Init OnCreate <******> **/
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    private fun InitOnCreate() {
        // View model reference
        val viewModel: MainVm = hiltViewModel()
        // View state reference from view model
        //val state = viewModel.viewState
        // --> This is used to update the Orientation
        handleConfigurationEffect()
        // --> Launch only once per session
        LaunchOncePerSession()

        // <!--------------------- CONTROLLERS ------------------------>
        // Nav controller
        val navController = rememberNavController()
        // <!--------------------- CONTROLLERS ------------------------>

        // <!------------- Bottom Navigation Controller --------------->
        // Keeps track of current selected position of bottom tab
        var bottomNavPosition by remember { mutableIntStateOf(BottomNavItem.initialPosition) }
        // Controller will be triggered position of hte tab is updated
        BottomNavigationController(bottomNavPosition, navController)
        // <!------------- Bottom Navigation Controller --------------->

        CameraTheme(darkTheme = viewModel.currentTheme.value) {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    bottomBar = { BottomNavRow{ bottomNavPosition = it } }
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
        InitOnCreate()
    }
    /** ************************************* PREVIEW  ***************************************/

}