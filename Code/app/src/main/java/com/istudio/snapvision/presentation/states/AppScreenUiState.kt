package com.istudio.snapvision.presentation.states

import android.content.res.Configuration
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class AppScreenUiState(
    // By default - It is loading state
    val loadingState : Boolean = true,
    val isConnectedToInternet : Boolean = false,
    val launchedEffectState : Boolean = false,
    val errorMessage : String = "",
    val orientation : Int = Configuration.ORIENTATION_PORTRAIT
)
