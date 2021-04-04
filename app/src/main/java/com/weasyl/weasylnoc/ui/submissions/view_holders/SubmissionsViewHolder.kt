package com.weasyl.weasylnoc.ui.submissions.view_holders

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.weasyl.domain.constants.Constants.EXPLICIT
import com.weasyl.domain.constants.Constants.GENERAL
import com.weasyl.domain.constants.Constants.MATURE
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.submissions.adapters.SubmissionsAdapter
import kotlinx.android.synthetic.main.item_submission.view.*

class SubmissionsViewHolder(
    itemView: View,
    private val callback: SubmissionsAdapter.Callback
) : RecyclerView.ViewHolder(itemView) {
    lateinit var submissionEntity: SubmissionEntity

    fun bind(
        submissionEntity: SubmissionEntity,
        onClickListener: SubmissionsAdapter.OnClickListener?
    ) {
        this.submissionEntity = submissionEntity
        bindSubmission()
        bindTitle()
    }

    private fun bindTitle() {
        with(itemView) {
            val text = SpannableStringBuilder().append(
                submissionEntity.title
            ).append(" by ")
                .append(submissionEntity.owner)

            text.setSpan(
                RelativeSizeSpan(0.8f),
                submissionEntity.title.length,
                text.length,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )

            text.setSpan(
                ForegroundColorSpan(Color.parseColor("#BBBBBB")),
                submissionEntity.title.length,
                text.length,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )

            when (submissionEntity.rating) {
                EXPLICIT -> {
                    tvRating.text = "E"
                    tvRating.setTextColor(Color.parseColor("#A31F1F"))
                }
                MATURE -> {
                    tvRating.text = "M"
                    tvRating.setTextColor(Color.parseColor("#A9BA22"))
                }
                GENERAL -> {
                    tvRating.text = "G"
                    tvRating.setTextColor(Color.parseColor("#FFFFFF"))
                }
            }

            tvTitle.text = text
        }
    }

    private fun bindSubmission() {
        with(itemView) {
            Picasso.get().load(submissionEntity.media.cover[0].url)
                .placeholder(R.drawable.placeholder).into(ivSubmission)
            itemView.ivSubmission.setOnClickListener {
                callback.onItemClicked(submissionEntity.id, submissionEntity.media.cover[0].url)
            }
        }
    }

}