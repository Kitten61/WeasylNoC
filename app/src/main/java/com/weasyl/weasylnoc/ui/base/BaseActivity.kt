package com.weasyl.weasylnoc.ui.base

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import com.arellomobile.mvp.MvpAppCompatActivity
import com.weasyl.weasylnoc.R

abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }

    fun setUpActionBar(view: View?, isToolbarNeed: Boolean) {
        if (!isToolbarNeed) {
            return
        }
        if (view == null) {
            supportActionBar?.hide()
            return
        }

        supportActionBar?.show()
        supportActionBar?.apply {
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            setDisplayShowCustomEnabled(true)
            setCustomView(
                view,
                ActionBar.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
            elevation = 0f
        }
        val toolbar = view.parent as Toolbar
        toolbar.setContentInsetsAbsolute(0, 0)
    }

    open fun setUpListeners() {}

    override fun showError(message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun navigateToPreviousScene() {
        finish()
    }

}