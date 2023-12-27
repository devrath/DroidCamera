package com.istudio.snapvision.presentation.states

sealed class AppScreenResponseEvent {
    // object ToggleData : AppScreenResponseEvent()
    data class ShowSnackBar(val message: String) : AppScreenResponseEvent()
}
