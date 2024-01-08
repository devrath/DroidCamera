package com.istudio.feature_onboarding.domain.usecases.cases

import com.istudio.core_preferences.data.PrefsStore
import javax.inject.Inject

/**
 * USE-CASE: Check if on-boarding is complete
 * Returns true if onboarding is complete Else it returns false
 */
class CheckIfOnboardingIsComplete @Inject constructor(
    private val preferences: PrefsStore
) {
    operator fun invoke(): Boolean {
        return preferences.isOnBoardingDone() as Boolean
    }
}