package com.istudio.feature_onboarding.presentation.states

sealed class OnBoardingViewEvent {
    object NextButtonClicked : OnBoardingViewEvent()
}