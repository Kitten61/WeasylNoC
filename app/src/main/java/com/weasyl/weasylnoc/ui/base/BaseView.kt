package com.weasyl.weasylnoc.ui.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BaseView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(message: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToPreviousScene()

}
