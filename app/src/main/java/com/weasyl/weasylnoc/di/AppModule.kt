package com.weasyl.weasylnoc.di

import android.content.Context
import android.content.SharedPreferences
import com.weasyl.domain.constants.SharedPreferencesConst.Companion.SHARED_PREFERENCES
import com.weasyl.weasylnoc.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: App) {

    @Provides
    @Singleton
    fun providesApplication(): App = application

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
        application.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
}
