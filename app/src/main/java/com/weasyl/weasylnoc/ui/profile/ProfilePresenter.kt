package com.weasyl.weasylnoc.ui.profile

import com.arellomobile.mvp.InjectViewState
import com.weasyl.domain.usecases.user.UserDataUseCase
import com.weasyl.weasylnoc.ui.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
    private val userDataUseCase: UserDataUseCase
) : BasePresenter<ProfileView>(), CoroutineScope {

    override fun onFirstViewAttach() {
        loadSelfData()
    }

    private fun loadSelfData() {
        launch(IO) {
            val userData = userDataUseCase.getUserData("fluff-kevlar")
            launch(Main) {
                viewState.setUpUser(userData!!)
            }
        }
    }

}