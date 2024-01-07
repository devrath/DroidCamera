package com.istudio.feature_onboarding.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.core_ui.composable.AppButton
import com.istudio.feature_onboarding.presentation.composables.SplashAnimation

@Composable
fun OnboardingScreen(navController: NavHostController){

    val viewModel: OnboardingScreenVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // Camera Animation
        SplashAnimation(
            modifier = Modifier.weight(3f)
        )

        // Action 
        Column(
            modifier = Modifier.weight(1f).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppButton(buttonText = "Next"){
                // Action
            }
        }

    }

}

@Composable
@Preview
private fun CurrentScreen(){
    OnboardingScreen(navController = NavHostController(LocalContext.current))
}