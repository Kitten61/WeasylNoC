package com.weasyl.weasylnoc.di

import com.weasyl.weasylnoc.ui.activity.MainActivity
import com.weasyl.weasylnoc.ui.activity.MainPresenter
import com.weasyl.weasylnoc.ui.login.LoginPresenter
import com.weasyl.weasylnoc.ui.profile.ProfilePresenter
import com.weasyl.weasylnoc.ui.splash.SplashPresenter
import com.weasyl.weasylnoc.ui.submissions.SubmissionsPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, GatewayModule::class, UseCaseModule::class])
interface AppComponent {

    fun provideMainPresenter() : MainPresenter
    fun provideSplashPresenter(): SplashPresenter
    fun provideLoginPresenter(): LoginPresenter
    fun provideProfilePresenter(): ProfilePresenter
    fun provideSubmissionsPresenter(): SubmissionsPresenter

    fun inject(target: MainActivity)

}