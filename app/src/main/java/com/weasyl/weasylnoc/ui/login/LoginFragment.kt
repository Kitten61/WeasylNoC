package com.weasyl.weasylnoc.ui.login

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter() = App.appComponent.provideLoginPresenter()

    override val layoutId: Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        apiKeyButton.setOnClickListener({
            presenter.loginUser(
                apiKeyEditText.text.toString()
            )
        })
    }

    override fun showError(messenge: Int) {
        Toast.makeText(requireContext(), R.string.api_key_error, Toast.LENGTH_LONG).show()
    }

    override fun saveUserData(apiKey: String) {
        requireActivity().getSharedPreferences("weasyl", Context.MODE_PRIVATE).edit()
            .putString("api-key", apiKey).apply()
    }
}