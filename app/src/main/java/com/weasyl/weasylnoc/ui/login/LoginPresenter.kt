package com.weasyl.weasylnoc.ui.login

import com.arellomobile.mvp.InjectViewState
import com.weasyl.domain.gateways.AuthorizationGateway
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.Screens
import com.weasyl.weasylnoc.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LoginPresenter @Inject constructor(
    val router: Router,
    val auhorizationGateway: AuthorizationGateway
) : BasePresenter<LoginView>() {

    fun loginUser(apiKey: String) {
        auhorizationGateway.login(apiKey).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    viewState.saveUserData(apiKey)
                    navigateToContent()
                }, {
                    viewState.showError(R.string.api_key_error)
                }
            ).addTo(compositeDisposable)
    }



    fun navigateToContent() {
        router.navigateTo(Screens.ContentScreen())
    }

}