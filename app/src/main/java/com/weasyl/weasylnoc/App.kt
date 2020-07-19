package com.weasyl.weasylnoc

import android.app.Application
import android.util.Log
import com.weasyl.weasylnoc.di.AppComponent
import com.weasyl.weasylnoc.di.AppModule
import com.weasyl.weasylnoc.di.DaggerAppComponent
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }

}