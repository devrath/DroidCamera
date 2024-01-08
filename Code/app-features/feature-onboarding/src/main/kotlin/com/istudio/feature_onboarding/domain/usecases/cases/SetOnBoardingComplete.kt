package com.istudio.feature_onboarding.domain.usecases.cases

import com.istudio.core_preferences.data.PrefsStore
import javax.inject.Inject

/**
 * USE-CASE: Set that on-boarding is complete
 */
class SetOnBoardingComplete @Inject constructor(
    private val preferences: PrefsStore
) {
    suspend operator fun invoke() {
        preferences.setOnBoardingDone()
    }
}