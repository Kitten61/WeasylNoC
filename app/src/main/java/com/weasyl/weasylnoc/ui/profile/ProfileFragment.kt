package com.weasyl.weasylnoc.ui.profile

import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import com.weasyl.domain.entities.UserEntity
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.base.BaseFragment
import com.weasyl.weasylnoc.ui.profile.adapters.ProfileViewPagerAdapter
import com.weasyl.weasylnoc.ui.submissions.SubmissionsFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.toolbar.view.*
import kotlin.reflect.KClass


class ProfileFragment : BaseFragment(), ProfileView {

    override val layoutId: Int = R.layout.fragment_profile
    override var toolbarLayoutId: Int = R.layout.toolbar

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    @ProvidePresenter
    fun providePresenter() = App.appComponent.provideProfilePresenter()

    override fun setUpUser(userEntity: UserEntity) {
        Picasso.get().load(userEntity.media.avatar?.get(0)?.url).into(ivAvatar)
        tvName.text = userEntity.fullName
        tvUsername.text = userEntity.username
        toolbar?.let {
            it.tvTitle.text = userEntity.username
        }

        val viewPagerList = ArrayList<KClass<*>>()
        viewPagerList.add(SubmissionsFragment::class)
        viewPager.adapter = ProfileViewPagerAdapter(viewPagerList, parentFragmentManager, lifecycle)

        TabLayoutMediator(tlProfile, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Gallery"
                else -> ""
            }
        }.attach()

    }

    override fun setUpToolbar(toolbar: View?) {
        toolbar.apply {
        }
    }

    override fun setUpUI() {

    }


}