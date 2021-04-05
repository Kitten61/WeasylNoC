package com.weasyl.weasylnoc.ui.submission

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.weasylnoc.ui.base.BaseView

interface SubmissionView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setUpSubmissionInfo(submissionEntity: SubmissionEntity)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openImageViewer(url: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToProfileFragment(ownerLogin: String)

}