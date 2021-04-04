package com.weasyl.weasylnoc.ui.submissions

import com.arellomobile.mvp.InjectViewState
import com.weasyl.domain.entities.PaginationResponseEntity
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.domain.entities.UserLogonEntity
import com.weasyl.domain.gateways.FavoriteGateway
import com.weasyl.domain.usecases.submission.SubmissionUseCase
import com.weasyl.domain.usecases.user.UserDataUseCase
import com.weasyl.weasylnoc.ui.base.BasePaginationPresenter
import com.weasyl.weasylnoc.ui.base.BasePresenter
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import javax.inject.Inject

@InjectViewState
class SubmissionsPresenter @Inject constructor(
    private val submissionsUseCase: SubmissionUseCase,
    private val userDataUseCase: UserDataUseCase
) : BasePaginationPresenter<SubmissionsView<SubmissionEntity>, SubmissionEntity, SubmissionEntity>() {

    private lateinit var currentUser: UserLogonEntity

    override suspend fun getItems(
        nextId: Int?,
        limit: Int
    ): PaginationResponseEntity<SubmissionEntity> {
        currentUser = userDataUseCase.getCurrentUser()!!
        return submissionsUseCase.getSubmissions("fluffkevlar", nextId = nextId!!)
    }

}