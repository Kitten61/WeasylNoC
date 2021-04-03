package com.weasyl.weasylnoc.ui.login

import android.content.Context
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
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter() = App.appComponent.provideLoginPresenter()

    override val layoutId: Int = R.layout.fragment_login

    override fun setUpListeners() {
        requireActivity().getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE).edit()
            .putString(
                API_KEY,
                apiKeyEditText.text.toString()
            ).apply()
        apiKeyButton.setOnClickListener {
            presenter.loginUser()
        }
    }

    override fun navigateToContent() {
        (activity as MainActivity).setBottomNavigationVisible(true)
        findNavController().navigate(R.id.xml)
    }

    override fun showErrorMessage() {
        AlertDialog.Builder(requireContext()).setTitle(R.string.error)
            .setMessage(R.string.connection_error_message).show()
    }
}