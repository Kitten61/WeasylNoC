package com.weasyl.weasylnoc.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.plusAssign
import androidx.navigation.ui.setupWithNavController
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.weasyl.weasylnoc.App
import com.weasyl.weasylnoc.R
import com.weasyl.weasylnoc.navigation.KeepStateNavigator
import com.weasyl.weasylnoc.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = App.appComponent.provideMainPresenter()

    override val layoutId = R.layout.activity_main
    private val navController by lazy { findNavController(R.id.navHostFragment) }
    private val navigationItemReselectedListener =
        BottomNavigationView.OnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.nav_profile -> {
                    navigateToStart(R.id.profileFragment)
                }
                R.id.nav_submissions -> {
                    navigateToStart(R.id.profileFragment)
                }
                R.id.nav_settings -> {
                    navigateToStart(R.id.profileFragment)
                }
            }
        }

    init {
        App.appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKeepStateNavigator()
        setUpNavigationBar()
    }

    private fun setUpNavigationBar() {
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnNavigationItemReselectedListener(navigationItemReselectedListener)
    }

    fun setBottomNavigationVisible(isVisible: Boolean) {
        if (isVisible) {
            bottomNavigationView.visibility = View.VISIBLE
        } else {
            bottomNavigationView.visibility = View.GONE
        }
    }

    @SuppressLint("RestrictedApi")
    private fun initKeepStateNavigator() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment)!!
        val navigator = KeepStateNavigator(
            this,
            navHostFragment.childFragmentManager,
            R.id.navHostFragment
        )
        navController.apply {
            navigatorProvider += navigator
            navController.setGraph(R.navigation.content_nav_graph)
        }
    }

    private fun navigateToStart(fragmentId: Int, bundle: Bundle? = null) {
        getCurrentFragment()?.findNavController()?.navigate(
            fragmentId,
            bundle,
            NavOptions.Builder().setPopUpTo(fragmentId, true).build()
        )
    }

    private fun getCurrentFragment(): Fragment? {
        val containerFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment)?.childFragmentManager?.findFragmentById(
                R.id.navHostFragment
            ) ?: return null
        return containerFragment.childFragmentManager.fragments.first()
    }

}