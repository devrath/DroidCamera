package com.istudio.core_preferences.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

private const val STORE_NAME = "pref_is_on-boarding_done"

class PrefsStoreImpl  @Inject constructor(
    @ApplicationContext val context: Context
): PrefsStore {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = STORE_NAME)

    companion object {
        val IS_ON_BOARDING_DONE = booleanPreferencesKey(STORE_NAME)
    }

    // ****************** OnBoarding State ******************
    override fun isOnBoardingDone() = context.dataStore.data.catch { exception ->
        if (exception is IOException){
            emit(emptyPreferences())
        }else{
            throw exception
        }
    }.map { it[IS_ON_BOARDING_DONE] ?: false }

    override suspend fun setOnBoardingDone() {
        context.dataStore.edit { it[IS_ON_BOARDING_DONE] = true }
    }
    // ****************** OnBoarding State ******************


}