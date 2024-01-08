package com.istudio.feature_onboarding.presentation.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.core.content.ContextCompat
import com.istudio.core_common.platform.viewmodel.BaseVM
import com.istudio.feature_onboarding.domain.usecases.OnboardingUseCaseController
import com.istudio.feature_onboarding.presentation.states.OnBoardingViewEvent
import com.istudio.feature_onboarding.presentation.states.OnBoardingViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingScreenVm @Inject constructor(
    private val useCaseController : OnboardingUseCaseController
) : BaseVM<OnBoardingViewState, OnBoardingViewEvent>() {

    init {

    }

    val permissionsToRequest = arrayOf(Manifest.permission.CAMERA)
    val visiblePermissionDialogQueue = mutableStateListOf<String>()

    override fun onTriggerEvent(event: OnBoardingViewEvent) {
        when(event){
            OnBoardingViewEvent.NextButtonClicked -> {
                nextActionClicked()
            }
            else -> { }
        }
    }

    fun dismissDialog() {
        visiblePermissionDialogQueue.removeFirst()
    }

    fun onPermissionResult(permission: String, isGranted: Boolean) {
        if(!isGranted && !visiblePermissionDialogQueue.contains(permission)) {
            visiblePermissionDialogQueue.add(permission)
        }
    }


    fun isCameraPermissionGranted(activity : Context): Boolean {
        return ContextCompat.checkSelfPermission(
            activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * ******************************* USER ACTIONS *******************************
     */
    private fun nextActionClicked()  {

        val exceptionHandler = catchException { exception ->
            Log.d(tag,exception.message?:"Exception caught")
        }

        launchUseCase(exceptionHandler) {
            useCaseController.checkIfOnboardingIsComplete.invoke()?.let {
                if(it){
                    // Already on-boarding is done
                    updateState((viewState.value ?: OnBoardingViewState())
                        .copy(isOnboardingComplete = true))
                }else{
                    // Mark on-boarding is complete
                    useCaseController.setOnBoardingComplete.invoke()
                }
            }
        }
    }

    /**
     * ******************************* USER ACTIONS *******************************
     */


}