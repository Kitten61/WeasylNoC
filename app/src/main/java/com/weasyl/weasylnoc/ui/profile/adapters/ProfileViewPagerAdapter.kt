package com.weasyl.weasylnoc.ui.profile.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.weasyl.weasylnoc.ui.submissions.SubmissionsFragment
import kotlin.reflect.KClass

class ProfileViewPagerAdapter(
    private val itemsList: ArrayList<KClass<*>>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 1

    override fun createFragment(position: Int): Fragment {
        return SubmissionsFragment()
    }

}