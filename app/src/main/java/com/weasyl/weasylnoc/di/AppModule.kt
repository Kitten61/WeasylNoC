package com.weasyl.weasylnoc.di

import android.content.Context
import android.content.SharedPreferences
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
}
