package com.istudio.feature_camera.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.istudio.feature_camera.presentation.composables.ScrollableTabs

@Composable
fun CaptureScreen(navController: NavHostController) {

    val viewModel: CaptureScreenVm = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        // Contain camera
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .background(MaterialTheme.colorScheme.primary),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Capture Image",
                fontSize = 30.sp
            )
        }

        // Contain bottom scrollable tabs
        ScrollableTabs(modifier = Modifier.fillMaxWidth().weight(0.5f))
    }
}

@Preview
@Composable
private fun CaptureImageScreenPreview() {
    val navController = rememberNavController()
    Surface {
        CaptureScreen(navController = navController)
    }
}

