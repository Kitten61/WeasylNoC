package com.weasyl.weasylnoc.ui.profile.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.weasyl.weasylnoc.ui.profile.ProfileFragment
import com.weasyl.weasylnoc.ui.submissions.SubmissionsFragment

class ProfileViewPagerAdapter(
    private val fragment: Fragment,
    private val galleryCallback: SubmissionsFragment.Callback
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 1

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> createSubmissionsFragment()
            else -> createSubmissionsFragment()
        }
    }

    override fun onBindViewHolder(
        holder: FragmentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        (fragment.childFragmentManager.findFragmentByTag("f0") as SubmissionsFragment?)?.callback = galleryCallback
    }

    private fun createSubmissionsFragment() : SubmissionsFragment {
        val fragment = SubmissionsFragment.newInstance()
        fragment.callback = galleryCallback
        return fragment
    }

}