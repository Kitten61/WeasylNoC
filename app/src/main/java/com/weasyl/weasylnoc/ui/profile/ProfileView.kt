package com.weasyl.weasylnoc.ui.profile

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.weasyl.domain.entities.UserEntity
import com.weasyl.weasylnoc.ui.base.BaseView

interface ProfileView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setUpUser(userEntity: UserEntity)

}