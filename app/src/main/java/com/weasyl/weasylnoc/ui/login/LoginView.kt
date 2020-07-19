package com.weasyl.weasylnoc.ui.login

import com.arellomobile.mvp.MvpView

interface LoginView : MvpView {
    fun showError(messenge: Int)
    fun saveUserData(apiKey: String)
}
