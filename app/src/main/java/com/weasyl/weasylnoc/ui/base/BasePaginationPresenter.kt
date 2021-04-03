package com.weasyl.weasylnoc.ui.base

import com.weasyl.domain.constants.ApiConst.Companion.COUNT_PER_PAGE
import com.weasyl.domain.entities.PaginationResponseEntity
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

abstract class BasePaginationPresenter<T : BasePaginationView<M>, M, E> : BasePresenter<T>() {

    companion object {
        const val PAGE_SIZE = 15
    }

    protected var nextId: Int? = 0
    protected var isLoading = false
    protected val items = ArrayList<E>()

    abstract suspend fun getItems(nextId: Int?, limit: Int): PaginationResponseEntity<E>

    open fun onItemsLoadError() {
        //viewState.showMessage(R.string.something_went_wrong)
        viewState.hidePaginationLoader()
        viewState.hideRefreshLoader()
    }


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showRefreshLoader()
        loadFirstPage()
    }

    fun onSwipeToRefresh() {
        loadFirstPage()
    }

    fun onNewPageScrolled() {
        if (isLoading || nextId == null) {
            return
        }
        loadNewPage()
        viewState.showPaginationLoader()
    }


    open protected fun loadFirstPage(showRefresh: Boolean = true) {
        if (showRefresh) {
            isLoading = true
            viewState.showRefreshLoader()
        }
        launch(IO) {
            val loadedItems = getItems(nextId, COUNT_PER_PAGE)
            launch(Main) {
                items.apply {
                    clear()
                    addAll(loadedItems.submissions)
                }
                nextId = loadedItems.nextid
                showInitialItems(items)
                viewState.hideRefreshLoader()
                isLoading = false
            }
        }
    }

    protected fun loadNewPage() {
        isLoading = true
        launch(IO) {
            val loadedItems = getItems(nextId, COUNT_PER_PAGE)
            launch(Main) {
                items.apply {
                    clear()
                    addAll(loadedItems.submissions)
                }
                nextId = loadedItems.nextid
                showNewItems(items)
                viewState.hidePaginationLoader()
                isLoading = false
            }
        }
    }


    protected open fun showInitialItems(items: ArrayList<E>) {
        viewState.showInitialItems(mapItems(items))
    }

    protected open fun showNewItems(items: ArrayList<E>) {
        viewState.showNewItems(mapItems(items))
    }

    protected open fun mapItems(items: ArrayList<E>): ArrayList<M> {
        return items.mapTo(ArrayList()) { it as M }
    }

}