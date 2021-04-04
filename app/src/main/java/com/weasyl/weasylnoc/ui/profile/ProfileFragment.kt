package com.weasyl.weasylnoc.ui.profile

import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import com.stfalcon.imageviewer.StfalconImageViewer
import com.weasyl.domain.entities.UserEntity
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.base.BaseFragment
import com.weasyl.weasylnoc.ui.profile.adapters.ProfileViewPagerAdapter
import com.weasyl.weasylnoc.ui.submissions.SubmissionsFragment
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : BaseFragment(), ProfileView {

    override val layoutId: Int = R.layout.fragment_profile
    override var toolbarLayoutId: Int = R.layout.toolbar
    lateinit var profileAdapter: ProfileViewPagerAdapter

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    @ProvidePresenter
    fun providePresenter() = App.appComponent.provideProfilePresenter()

    override fun setUpUser(userEntity: UserEntity) {
        Picasso.get().load(userEntity.media.avatar?.get(0)?.url).into(ivAvatar)
        Picasso.get().load(userEntity.media.banner?.get(0)?.url).into(ivBanner)
        tvName.text = userEntity.fullName
        tvUsername.text = userEntity.username

    }

    override fun openImageViewer(image: String?) {
        StfalconImageViewer.Builder<String>(context, listOf(image)) { view, image ->
            Picasso.get().load(image).into(view)
        }
            .withTransitionFrom(ivAvatar)
            .show()
    }

    override fun navigateToSubmissionScreen() {
        ProfileFragmentDirections.actionProfileFragmentToSubmissionFragment().let(findNavController()::navigate)
    }

    override fun setUpListeners() {
        ivAvatar.setOnClickListener {
            presenter.onAvatarClicked()
        }
    }

    override fun setUpRecyclerViews() {
        profileAdapter = ProfileViewPagerAdapter(
            this,
            object : SubmissionsFragment.Callback {
                override fun onSubmissionClicked(id: Int, url: String) {
                    presenter.onSubmissionClicked(id)
                }
            }
        )

        viewPager.adapter = profileAdapter
        TabLayoutMediator(tlProfile, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Gallery"
                else -> ""
            }
        }.attach()
    }

}