package com.weasyl.weasylnoc.ui.splash

import com.arellomobile.mvp.InjectViewState
import com.weasyl.domain.enums.RetrofitState
import com.weasyl.domain.usecases.authorization.AuthorizationUseCase
import com.weasyl.weasylnoc.ui.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@InjectViewState
class SplashPresenter @Inject constructor(
    private val authorizationUseCase: AuthorizationUseCase
) : BasePresenter<SplashView>(), CoroutineScope {

    fun loginUser() {
        viewModelScope.launch(IO) {
            val state = authorizationUseCase.checkUser()
            launch(Main) {
                when (state) {
                    is RetrofitState.OK<*> -> viewState.navigateToContent()
                    is RetrofitState.Unauthorized -> viewState.navigateToLoginScreen()
                    else -> viewState.showErrorMessage()
                }
            }
        }
    }

}