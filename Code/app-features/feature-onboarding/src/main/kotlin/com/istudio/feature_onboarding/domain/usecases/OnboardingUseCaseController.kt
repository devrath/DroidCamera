package com.istudio.feature_onboarding.domain.usecases

import com.istudio.feature_onboarding.domain.usecases.cases.CheckIfOnboardingIsComplete
import com.istudio.feature_onboarding.domain.usecases.cases.SetOnBoardingComplete

data class OnboardingUseCaseController(
    val checkIfOnboardingIsComplete : CheckIfOnboardingIsComplete,
    val setOnBoardingComplete : SetOnBoardingComplete
)
