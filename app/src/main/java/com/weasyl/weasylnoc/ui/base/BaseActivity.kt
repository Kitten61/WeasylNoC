package com.weasyl.weasylnoc.ui.base

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

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
        //val toolbar = view.parent as Toolbar
        //toolbar.setContentInsetsAbsolute(0, 0)
    }

    override fun showError(message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}