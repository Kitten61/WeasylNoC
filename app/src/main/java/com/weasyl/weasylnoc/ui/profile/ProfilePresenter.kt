package com.weasyl.weasylnoc.ui.profile

import com.arellomobile.mvp.InjectViewState
import com.weasyl.domain.entities.UserEntity
import com.weasyl.domain.entities.UserLogonEntity
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

    var username: String? = null
    lateinit var currentUser: UserLogonEntity
    lateinit var userData: UserEntity

    override fun onFirstViewAttach() {
        loadSelfData()
    }

    private fun loadSelfData() {
        launch(IO) {
            if (username == null) {
                currentUser = userDataUseCase.getCurrentUser()!!
                username = currentUser.login
            }
            userData = userDataUseCase.getUserData(username!!)!!
            launch(Main) {
                viewState.setUpUser(userData)
            }
        }
    }

    fun onAvatarClicked() {
        viewState.openImageViewer(userData.media.avatar?.get(0)?.url)
    }

    fun onSubmissionClicked(id: Int) {
        viewState.navigateToSubmissionScreen(id)
    }

}