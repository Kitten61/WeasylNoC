package com.weasyl.weasylnoc.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weasyl.domain.constants.SharedPreferencesConst
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.activity.MainActivity
import com.weasyl.weasylnoc.ui.auth.AuthActivity
import com.weasyl.weasylnoc.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter() = App.appComponent.provideLoginPresenter()

    override val layoutId = R.layout.fragment_login

    override fun setUpListeners() {
        apiKeyButton.setOnClickListener {
            requireActivity().getSharedPreferences(
                SharedPreferencesConst.SHARED_PREFERENCES,
                Context.MODE_PRIVATE
            ).edit()
                .putString(
                    SharedPreferencesConst.API_KEY,
                    apiKeyEditText.text.toString()
                ).apply()
            presenter.loginUser()
        }
    }

    override fun navigateToContent() {
        requireActivity().startActivity(
            Intent(requireContext(), MainActivity::class.java)
        )
        requireActivity().finish()
    }

    override fun showErrorMessage() {
        AlertDialog.Builder(requireContext()).setTitle(R.string.error)
            .setMessage(R.string.connection_error_message).show()
    }

}