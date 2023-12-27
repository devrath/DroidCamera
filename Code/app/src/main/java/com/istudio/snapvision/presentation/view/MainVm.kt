package com.istudio.snapvision.presentation.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.istudio.core_common.platform.uiEvent.UiText
import com.istudio.core_common.platform.viewmodel.BaseViewModel
import com.istudio.snapvision.presentation.states.AppScreenResponseEvent
import com.istudio.snapvision.presentation.states.AppScreenUiState
import com.istudio.snapvision.presentation.states.AppScreenViewEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVm @Inject constructor( ): BaseViewModel<Unit>() {

    val currentTheme = mutableStateOf(false)

    // Holds the data of all the widgets in the view
    var viewState by mutableStateOf(AppScreenUiState())
        private set

    // View model sets this state, Composable observes this state
    private val _uiEvent = Channel<AppScreenResponseEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    /** <************> UI Action is invoked from composable <************> **/

    fun onEvent(event: AppScreenViewEvent) {
        viewModelScope.launch {
            when (event) {
                is AppScreenViewEvent.CheckConnectivity -> { }
                is AppScreenViewEvent.LoadingState -> { }
                is AppScreenViewEvent.SetMessageForError -> { }
                is AppScreenViewEvent.SetScreenOrientation -> {
                    // Main Activity Composable calls this to keep the current orientation of the screen
                    viewState = viewState.copy(orientation = event.orientation)
                }
            }
        }
    }

    /** <************> UI Action is invoked from composable <************> **/



    /** ********************************* DISPLAY MESSAGES ****************************************/
    /**
     * ERROR HANDLING:
     * Displaying messages to the snack-bar
     */
    private suspend fun displayErrorInSnackBar(result: UiText?) {
        result?.let { _uiEvent.send(AppScreenResponseEvent.ShowSnackBar(it.toString())) }
    }
    /** ********************************* DISPLAY MESSAGES ****************************************/


    override fun setupPrerequisites(params: Unit) { }


}