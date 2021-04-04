package com.weasyl.weasylnoc.ui.splash

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.activity.MainActivity
import com.weasyl.weasylnoc.ui.base.BaseFragment
import com.weasyl.weasylnoc.ui.login.LoginFragment

class SplashFragment : BaseFragment(), SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter = App.appComponent.provideSplashPresenter()

    override val layoutId: Int = R.layout.fragment_splash

    override fun navigateToLoginScreen() {
        SplashFragmentDirections.openLoginFragment().let(findNavController()::navigate)
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
        requireActivity().startActivity(
            Intent(requireContext(), MainActivity::class.java)
        )
        requireActivity().finish()
    }
}