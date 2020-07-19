package com.weasyl.weasylnoc.ui.content

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.base.BaseFragment

class ContentFragment : BaseFragment(), ContentView {

    override val layoutId = R.layout.fragment_content

    @InjectPresenter
    lateinit var presenter: ContentPresenter

    @ProvidePresenter
    fun providePresenter() = App.appComponent.provideContentPresenter()

}
