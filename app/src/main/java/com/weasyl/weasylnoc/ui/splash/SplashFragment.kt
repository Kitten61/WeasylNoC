package com.weasyl.weasylnoc.ui.splash

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weasyl.domain.constants.SharedPreferencesConst.Companion.API_KEY
import com.weasyl.domain.constants.SharedPreferencesConst.Companion.SHARED_PREFERENCES
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.activity.MainActivity
import com.weasyl.weasylnoc.ui.base.BaseFragment

class SplashFragment : BaseFragment(), SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter = App.appComponent.provideSplashPresenter()

    override val layoutId: Int = R.layout.fragment_splash

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.loginUser()
    }

    override fun navigateToLoginScreen() {
        findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
    }

    override fun showErrorMessage() {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.error)
            .setMessage(R.string.connection_error_message)
            .setPositiveButton(R.string.retry) { _: DialogInterface, _: Int ->
                presenter.loginUser()
            }.setCancelable(false)
            .show()
    }

    override fun navigateToContent() {
        (activity as MainActivity).setBottomNavigationVisible(true)
        findNavController().navigate(R.id.xml)
    }
}