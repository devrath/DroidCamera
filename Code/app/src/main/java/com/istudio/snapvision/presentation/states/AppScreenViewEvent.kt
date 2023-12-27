package com.istudio.snapvision.presentation.states

sealed class AppScreenViewEvent {
    data class LoadingState(val isVisible : Boolean) : AppScreenViewEvent()
    object CheckConnectivity : AppScreenViewEvent()
    data class SetScreenOrientation(val orientation : Int) : AppScreenViewEvent()
    data class SetMessageForError(val message : String) : AppScreenViewEvent()
}
