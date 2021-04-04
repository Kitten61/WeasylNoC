package com.weasyl.weasylnoc.ui.submissions

import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.ui.adapters.PaginationScrollListener
import com.weasyl.weasylnoc.ui.base.BasePaginationFragment
import com.weasyl.weasylnoc.ui.base.BasePaginationPresenter
import com.weasyl.weasylnoc.ui.submissions.adapters.SubmissionsAdapter
import kotlinx.android.synthetic.main.fragment_pagination.*

class SubmissionsFragment : BasePaginationFragment<SubmissionEntity>(), SubmissionsView<SubmissionEntity> {

    interface Callback {
        fun onSubmissionClicked(id: Int, url: String)
    }

    var callback: Callback? = null
    private lateinit var submissionsAdapter: SubmissionsAdapter
    private lateinit var itemsAdapter: ConcatAdapter

    override val layoutId: Int = R.layout.fragment_pagination

    @InjectPresenter
    lateinit var presenter: SubmissionsPresenter

    @ProvidePresenter
    fun providePresenter() = App.appComponent.provideSubmissionsPresenter()

    override fun setUpRecyclerViews() {
        with(rvContent) {
            adapter = itemsAdapter
            this.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun setUpAdapters() {
        submissionsAdapter = SubmissionsAdapter(
            object : SubmissionsAdapter.Callback {
                override fun onItemClicked(id: Int, url: String) {
                    callback?.onSubmissionClicked(id, url)
                }
            }
        )
        itemsAdapter = ConcatAdapter(submissionsAdapter)
    }

    override fun setUpListeners() {
        rvContent.addOnScrollListener(PaginationScrollListener(BasePaginationPresenter.PAGE_SIZE) {
            presenter.onNewPageScrolled()
        })
    }

    override fun showRefreshLoader() {
    }

    override fun hideRefreshLoader() {
    }

    override fun showPaginationLoader() {
    }

    override fun hidePaginationLoader() {
    }

    override fun showNewItems(items: ArrayList<SubmissionEntity>) {
        submissionsAdapter.addItems(items)
    }

    override fun showInitialItems(items: ArrayList<SubmissionEntity>) {
        submissionsAdapter.addItems(items)
    }

    companion object {
        fun newInstance(): SubmissionsFragment {
            val args = Bundle()
            val fragment = SubmissionsFragment()
            fragment.arguments = args
            return fragment
        }
    }

}