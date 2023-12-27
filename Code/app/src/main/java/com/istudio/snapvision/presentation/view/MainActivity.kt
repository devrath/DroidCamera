package com.istudio.snapvision.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.istudio.core_navigation.NavGraph
import com.istudio.snapvision.presentation.view.view_navigation.BottomNavItem
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

        // List of items/screens for bottom tab
        val items = listOf(
            BottomNavItem(title = BottomNavItem.CaptureImage),
            BottomNavItem(title = BottomNavItem.RecordVideo)
        )
        // Keeps track of current selected position of bottom tab
        var bottomNavposition by remember { mutableIntStateOf(BottomNavItem.initialPosition) }
        // Controller will be triggered position of hte tab is updated
        BottomNavigationController(bottomNavposition, navController)

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
                    bottomBar = {
                        BottomAppBar(
                            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
                            tonalElevation = 8.dp
                        ) {
                            val weight = 1f / items.size
                            items.forEachIndexed { index, tabData ->
                                IconButton(
                                    onClick = { bottomNavposition = index },
                                    modifier = Modifier
                                        .weight(weight)
                                        .padding(8.dp)
                                ) {
                                    Icon(
                                        imageVector = if (index == 0) {
                                            Icons.Default.PhotoCamera
                                        } else {
                                            Icons.Default.Videocam
                                        },
                                        contentDescription = items[index].title
                                    )
                                }
                            }
                        }
                    }
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