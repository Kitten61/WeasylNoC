package com.weasyl.weasylnoc.di

import com.weasyl.weasylnoc.ui.activity.MainActivity
import com.weasyl.weasylnoc.ui.activity.MainPresenter
import com.weasyl.weasylnoc.ui.content.ContentPresenter
import com.weasyl.weasylnoc.ui.login.LoginPresenter
import com.weasyl.weasylnoc.ui.profile.ProfilePresenter
import com.weasyl.weasylnoc.ui.splash.SplashPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, GatewayModule::class, NavigationModule::class])
interface AppComponent {

    fun provideMainPresenter() : MainPresenter

    fun inject(target: MainActivity)
    fun provideSplashPresenter(): SplashPresenter
    fun provideContentPresenter(): ContentPresenter
    fun provideLoginPresenter(): LoginPresenter
    fun provideProfilePresenter(): ProfilePresenter
}