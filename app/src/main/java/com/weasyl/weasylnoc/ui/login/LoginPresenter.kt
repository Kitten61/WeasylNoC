package com.weasyl.weasylnoc.ui.login

import com.arellomobile.mvp.InjectViewState
import com.weasyl.domain.enums.RetrofitState
import com.weasyl.domain.gateways.AuthorizationGateway
import com.weasyl.domain.usecases.authorization.AuthorizationUseCase
import com.weasyl.weasylnoc.ui.base.BasePresenter
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.io.IOException
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@InjectViewState
class LoginPresenter @Inject constructor(
    private val authorizationUseCase: AuthorizationUseCase
) : BasePresenter<LoginView>() {

    fun loginUser() {
        launch(IO) {
            val state = authorizationUseCase.checkUser()
            launch(Main) {
                when (state) {
                    is RetrofitState.OK<*> -> {
                        viewState.navigateToContent()
                    }
                    is RetrofitState.Unauthorized -> viewState.showErrorMessage()
                    else -> viewState.showErrorMessage()
                }
            }
        }
    }

}