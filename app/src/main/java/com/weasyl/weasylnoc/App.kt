package com.weasyl.weasylnoc

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.weasyl.domain.constants.SharedPreferencesConst.Companion.SHARED_PREFERENCES
import com.weasyl.weasylnoc.di.AppComponent
import com.weasyl.weasylnoc.di.AppModule
import com.weasyl.weasylnoc.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        preferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var preferences: SharedPreferences
    }

}