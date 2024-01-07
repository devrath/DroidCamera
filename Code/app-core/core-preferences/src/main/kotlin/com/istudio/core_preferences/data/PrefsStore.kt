package com.istudio.core_preferences.data

import kotlinx.coroutines.flow.Flow

interface PrefsStore {

    // ****************** OnBoarding State ******************
    fun isOnBoardingDone(): Flow<Any>
    suspend fun setOnBoardingDone()
    // ****************** OnBoarding State ******************

}