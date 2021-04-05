package com.weasyl.weasylnoc.di

import com.weasyl.weasylnoc.ui.activity.MainActivity
import com.weasyl.weasylnoc.ui.activity.MainPresenter
import com.weasyl.weasylnoc.ui.auth.AuthPresenter
import com.weasyl.weasylnoc.ui.favorites.FavoritesPresenter
import com.weasyl.weasylnoc.ui.login.LoginPresenter
import com.weasyl.weasylnoc.ui.profile.ProfilePresenter
import com.weasyl.weasylnoc.ui.splash.SplashPresenter
import com.weasyl.weasylnoc.ui.submission.SubmissionPresenter
import com.weasyl.weasylnoc.ui.submissions.SubmissionsPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, GatewayModule::class, UseCaseModule::class])
interface AppComponent {

    fun provideMainPresenter(): MainPresenter
    fun provideSplashPresenter(): SplashPresenter
    fun provideAuthPresenter(): AuthPresenter
    fun provideProfilePresenter(): ProfilePresenter
    fun provideSubmissionsPresenter(): SubmissionsPresenter
    fun provideLoginPresenter(): LoginPresenter
    fun provideSubmissionPresenter(): SubmissionPresenter
    fun provideFavoritesPresenter(): FavoritesPresenter

    fun inject(target: MainActivity)

}