package com.weasyl.weasylnoc.ui.splash

import com.arellomobile.mvp.InjectViewState
import com.weasyl.domain.gateways.AuthorizationGateway
import com.weasyl.weasylnoc.Screens
import com.weasyl.weasylnoc.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(
    val router: Router,
    val auhorizationGateway: AuthorizationGateway
) : BasePresenter<SplashView>() {

    fun loginUser(apiKey: String) {
        auhorizationGateway.login(apiKey).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    navigateToContentScreen()
                }, {
                    navigateToLoginScreen()
                }
            ).addTo(compositeDisposable)
    }

    fun navigateToLoginScreen() {
        router.navigateTo(Screens.LoginScreen())
    }

    fun navigateToContentScreen() {
        router.navigateTo(Screens.ContentScreen())
    }

}