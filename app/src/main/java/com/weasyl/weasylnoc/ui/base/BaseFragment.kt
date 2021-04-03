package com.weasyl.weasylnoc.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    abstract val layoutId: Int
    open var isToolbarNeed = true
    open var toolbarLayoutId: Int = -1
    var toolbar: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAdapters()
        toolbar = if (toolbarLayoutId != -1) {
            LayoutInflater.from(activity).inflate(toolbarLayoutId, null)
        } else {
            null
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerViews()
        setUpListeners()
        setUpUI()
    }

    override fun showError(message: Int) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    open fun setUpAdapters() {

    }

    open fun setUpRecyclerViews() {

    }

    open fun setUpListeners() {

    }

    open fun setUpUI() {

    }


    open fun setUpToolbar(toolbar: View?) {

    }


    private fun updateToolbar() {
        setUpToolbar(toolbar)
        (activity as BaseActivity).setUpActionBar(toolbar, isToolbarNeed)
    }

    override fun onResume() {
        super.onResume()
        updateToolbar()
    }

    override fun onDestroy() {
        super.onDestroy()
        toolbar = null
    }


}