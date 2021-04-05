package com.weasyl.weasylnoc.ui.submission

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.squareup.picasso.Picasso
import com.stfalcon.imageviewer.StfalconImageViewer
import com.weasyl.domain.constants.Constants
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.helpers.DataConverter
import com.weasyl.weasylnoc.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_submission.*
import kotlinx.android.synthetic.main.fragment_submission.ivAvatar
import kotlinx.android.synthetic.main.fragment_submission.tvName

class SubmissionFragment : BaseFragment(), SubmissionView {

    @InjectPresenter
    lateinit var presenter: SubmissionPresenter

    @ProvidePresenter
    fun providePresenter() = App.appComponent.provideSubmissionPresenter()

    override val layoutId = R.layout.fragment_submission
    override var toolbarLayoutId = R.layout.toolbar_with_back_button

    val args: SubmissionFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.submitId = args.submitId
    }

    override fun setUpSubmissionInfo(submissionEntity: SubmissionEntity) {
        Picasso.get().load(submissionEntity.media.cover[0].url)
            .placeholder(R.drawable.placeholder).into(ivSubmission)
        Picasso.get().load(submissionEntity.ownerMedia.avatar?.get(0)?.url).into(ivAvatar)
        tvName.text = submissionEntity.owner
        tvTitle.text = submissionEntity.title
        tvTime.text = DataConverter.convert(submissionEntity.postDate)
        when (submissionEntity.rating) {
            Constants.EXPLICIT -> {
                tvRating.text = "E"
                tvRating.setTextColor(Color.parseColor("#A31F1F"))
            }
            Constants.MATURE -> {
                tvRating.text = "M"
                tvRating.setTextColor(Color.parseColor("#A9BA22"))
            }
            Constants.GENERAL -> {
                tvRating.text = "G"
                tvRating.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
    }

    override fun openImageViewer(url: String) {
        StfalconImageViewer.Builder<String>(context, listOf(url)) { view, image ->
            Picasso.get().load(image).into(view)
        }
            .withTransitionFrom(ivSubmission)
            .show()
    }

    override fun navigateToProfileFragment(ownerLogin: String) {
        SubmissionFragmentDirections.actionSubmissionFragmentToProfileFragment(username = ownerLogin).let(findNavController()::navigate)
    }

    override fun setUpListeners() {
        ivSubmission.setOnClickListener {
            presenter.onSubmissionClicked()
        }
        ivAvatar.setOnClickListener {
            presenter.onOwnerClicked()
        }
        tvName.setOnClickListener {
            presenter.onOwnerClicked()
        }
    }

//    override fun setUpToolbar(toolbar: View?) {
//        toolbar?.apply {
//            btnBack.setOnClickListener {
//                presenter.onBtnBackClicked()
//            }
//        }
//    }

}