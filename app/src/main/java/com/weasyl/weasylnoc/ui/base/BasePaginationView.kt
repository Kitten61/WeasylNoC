package com.weasyl.weasylnoc.ui.base

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BasePaginationView<I> : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showRefreshLoader()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun hideRefreshLoader()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showPaginationLoader()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun hidePaginationLoader()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showNewItems(items: ArrayList<I>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showInitialItems(items: ArrayList<I>)

}