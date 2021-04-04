package com.weasyl.weasylnoc.ui.profile

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.domain.entities.UserEntity
import com.weasyl.weasylnoc.ui.base.BasePaginationView
import com.weasyl.weasylnoc.ui.base.BaseView

interface ProfileView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setUpUser(userEntity: UserEntity)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openImageViewer(image: String?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToSubmissionScreen()

}