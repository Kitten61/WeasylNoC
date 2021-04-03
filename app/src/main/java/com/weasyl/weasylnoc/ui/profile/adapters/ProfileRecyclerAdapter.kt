package com.weasyl.weasylnoc.ui.profile.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.profile.view_holders.ContainerViewHolder

class ProfileRecyclerAdapter : RecyclerView.Adapter<ContainerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContainerViewHolder =
        ContainerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_container, parent, false)
        )

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: ContainerViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemViewType(position: Int): Int =
        when (position) {
            0 -> GALLERY
            1 -> POSTS
            2 -> JOURNALS
            else -> 0
        }

    companion object {
        const val GALLERY = 0
        const val POSTS = 1
        const val JOURNALS = 2
    }

}