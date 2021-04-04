package com.weasyl.weasylnoc.ui.submission

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.base.BaseFragment
import com.weasyl.weasylnoc.ui.profile.ProfilePresenter

class SubmissionFragment : BaseFragment(), SubmissionView {

    @InjectPresenter
    lateinit var presenter: SubmissionPresenter

    @ProvidePresenter
    fun providePresenter() = App.appComponent.provideSubmissionPresenter()

    override val layoutId = R.layout.fragment_submission

//    val args: ProfileFragmentArgs by navArgs()

}