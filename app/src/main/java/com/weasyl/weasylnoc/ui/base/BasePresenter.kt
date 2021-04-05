package com.weasyl.weasylnoc.ui.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<T: BaseView> : MvpPresenter<T>(), CoroutineScope{

    protected val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job
    protected val viewModelScope = CoroutineScope(coroutineContext)

    override fun onDestroy() {
        viewModelScope.cancel()
    }

    open fun onBtnBackClicked() {
        viewState.navigateToPreviousScene()
    }

}