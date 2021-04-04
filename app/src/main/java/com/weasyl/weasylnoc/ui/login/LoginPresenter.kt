package com.weasyl.weasylnoc.ui.login

import com.arellomobile.mvp.InjectViewState
import com.weasyl.domain.enums.RetrofitState
import com.weasyl.domain.usecases.authorization.AuthorizationUseCase
import com.weasyl.weasylnoc.ui.base.BasePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@InjectViewState
class LoginPresenter @Inject constructor(
    private val authorizationUseCase: AuthorizationUseCase
) : BasePresenter<LoginView>() {

    fun loginUser() {
        launch(Dispatchers.IO) {
            val state = authorizationUseCase.checkUser()
            launch(Dispatchers.Main) {
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