package com.weasyl.weasylnoc.ui.submissions.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.submissions.view_holders.SubmissionsViewHolder

class SubmissionsAdapter(
    private val callback: Callback
) : RecyclerView.Adapter<SubmissionsViewHolder>() {

    interface Callback {
        fun onItemClicked(id: Int, url: String)
    }

    private var items = ArrayList<SubmissionEntity>()
    var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubmissionsViewHolder =
        SubmissionsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_submission, parent, false),
            callback
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SubmissionsViewHolder, position: Int) {
        holder.bind(items[position], onClickListener)
    }

    fun addItems(items: ArrayList<SubmissionEntity>) {
        this.items.addAll(items)
        notifyItemRangeInserted(this.items.size - items.size, items.size)
    }

    interface OnClickListener {

    }
}