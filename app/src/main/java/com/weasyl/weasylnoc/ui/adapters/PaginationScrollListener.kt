package com.weasyl.weasylnoc.ui.adapters

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PaginationScrollListener(
    private val pageSize: Int,
    private val onLoadMore: () -> Unit
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        Log.e(
            "TESSST",
            "" + visibleItemCount + "+" + firstVisibleItemPosition + " " + (totalItemCount - 3)
        )

        if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount - 3
            && firstVisibleItemPosition >= 0
            && totalItemCount >= pageSize
        ) {
            onLoadMore.invoke()
        }
    }
}
