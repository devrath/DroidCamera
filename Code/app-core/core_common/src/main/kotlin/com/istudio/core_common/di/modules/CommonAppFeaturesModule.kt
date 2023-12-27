package com.istudio.core_common.di.modules

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.Gson
import com.istudio.core_common.platform.extensions.connectivityManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonAppFeaturesModule {

    @Singleton
    @Provides
    fun providesConnectivityManager(
        @ApplicationContext context: Context
    ): ConnectivityManager {
        return context.connectivityManager
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

}