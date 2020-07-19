package com.weasyl.weasylnoc.ui.splash

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.base.BaseFragment
import javax.inject.Inject

class SplashFragment : BaseFragment(), SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter() : SplashPresenter = App.appComponent.provideSplashPresenter()

    override val layoutId: Int = R.layout.fragment_splash

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPreferences = requireActivity().getSharedPreferences("weasyl", Context.MODE_PRIVATE)
        val apiKey = sharedPreferences.getString("api-key", "")
        apiKey?.let {
            presenter.loginUser(apiKey)
        }
    }
}