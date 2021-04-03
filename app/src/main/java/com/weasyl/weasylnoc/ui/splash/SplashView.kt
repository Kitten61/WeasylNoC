package com.weasyl.weasylnoc.ui.splash

import com.weasyl.weasylnoc.ui.base.BaseView

interface SplashView : BaseView {
    fun navigateToLoginScreen()
    fun showErrorMessage()
    fun navigateToContent()
}
