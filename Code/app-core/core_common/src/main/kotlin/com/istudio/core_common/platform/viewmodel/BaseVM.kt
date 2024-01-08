package com.istudio.core_common.platform.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseVM<ViewState, Event> : ViewModel() {

    val tag = this.javaClass.simpleName

    private val _viewState = MutableStateFlow<ViewState?>(null)
    val viewState = _viewState.asStateFlow()


    /** ******************** <-- View <--> ViewModel - Communication --> *********************** **/
    // --> View model uses this to update the composable
    fun updateState(viewState:ViewState){ _viewState.value=viewState }
    // --> View triggers the view-model using this function
    abstract fun onTriggerEvent(event:Event)
    /** ******************** <-- View <--> ViewModel - Communication --> *********************** **/

    /** **************************** <-- Use Case Launch/Handle --> **************************** **/
    inline fun ViewModel.launchUseCase(
        handler: CoroutineExceptionHandler,
        crossinline block: suspend () -> Unit
    ): Job = viewModelScope.launch(handler) { block() }

    inline fun ViewModel.catchException(crossinline block: (exception: Throwable) -> Unit): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { _, exception ->
            block(exception)
        }
    }
    /** **************************** <-- Use Case Launch/Handle --> **************************** **/


    /** ************************** View-Model-Scoping ************************** **/
    /**
     * This is the job for all coroutines started by this ViewModel.
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    private val viewModelJob = SupervisorJob()

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     * Since we pass viewModelJob, you can cancel all coroutines
     * launched by uiScope by calling viewModelJob.cancel()
     */
    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    /**
     * Cancel all coroutines when the ViewModel is cleared
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    /** ************************** View-Model-Scoping ************************** **/

}