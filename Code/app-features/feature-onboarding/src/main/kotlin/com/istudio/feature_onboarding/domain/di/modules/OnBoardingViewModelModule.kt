package com.istudio.feature_onboarding.domain.di.modules

import com.istudio.core_preferences.data.PrefsStore
import com.istudio.feature_onboarding.domain.usecases.OnboardingUseCaseController
import com.istudio.feature_onboarding.domain.usecases.cases.CheckIfOnboardingIsComplete
import com.istudio.feature_onboarding.domain.usecases.cases.SetOnBoardingComplete
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object OnBoardingViewModelModule {

    @ViewModelScoped
    @Provides
    fun provideRepositoryFeatures(
        preferences: PrefsStore
    ) : OnboardingUseCaseController {
         return preferences.let {

            val checkIfOnboardingIsComplete = CheckIfOnboardingIsComplete(it)
            val setOnBoardingComplete = SetOnBoardingComplete(it)

            // We return a different object
            OnboardingUseCaseController(
                checkIfOnboardingIsComplete = checkIfOnboardingIsComplete,
                setOnBoardingComplete = setOnBoardingComplete
            )
        }
    }

}