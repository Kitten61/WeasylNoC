package com.weasyl.weasylnoc.ui.login

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.weasyl.weasylnoc.ui.base.BaseView

interface LoginView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun navigateToContent()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showErrorMessage()
}
