package com.weasyl.weasylnoc

import androidx.fragment.app.Fragment
import com.weasyl.weasylnoc.ui.content.ContentFragment
import com.weasyl.weasylnoc.ui.login.LoginFragment
import com.weasyl.weasylnoc.ui.splash.SplashFragment
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class LoginScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment = LoginFragment()
    }

    class SplashScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment = SplashFragment()
    }

    class ContentScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment = ContentFragment()
    }

}