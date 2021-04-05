package com.weasyl.weasylnoc.ui.submission

import com.arellomobile.mvp.InjectViewState
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.domain.usecases.submission.SubmissionUseCase
import com.weasyl.weasylnoc.ui.base.BasePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@InjectViewState
class SubmissionPresenter @Inject constructor(
    private val submissionsUseCase: SubmissionUseCase
) : BasePresenter<SubmissionView>() {

    var submitId: Int = 0
    private lateinit var submissionEntity: SubmissionEntity

    override fun onFirstViewAttach() {
        loadSubmitInfo()
    }

    private fun loadSubmitInfo() {
        launch(Dispatchers.IO) {
            submissionEntity = submissionsUseCase.getSubmission(submitId)
            launch(Dispatchers.Main) {
                viewState.setUpSubmissionInfo(submissionEntity)
            }
        }
    }

    fun onSubmissionClicked() {
        viewState.openImageViewer(submissionEntity.media.cover[0].url)
    }

    fun onOwnerClicked() {
        viewState.navigateToProfileFragment(submissionEntity.ownerLogin)
    }

}