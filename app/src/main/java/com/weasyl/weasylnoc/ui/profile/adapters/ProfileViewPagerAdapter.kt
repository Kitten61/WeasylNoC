package com.weasyl.weasylnoc.ui.profile.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.weasyl.weasylnoc.ui.favorites.FavoritesFragment
import com.weasyl.weasylnoc.ui.submissions.SubmissionsFragment

class ProfileViewPagerAdapter(
    private val fragment: Fragment,
    val username: String?,
    private val galleryCallback: SubmissionsFragment.Callback
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> createSubmissionsFragment()
            1 -> createFavoritesFragment()
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
        (fragment.childFragmentManager.findFragmentByTag("f0") as SubmissionsFragment?)?.username = username

        (fragment.childFragmentManager.findFragmentByTag("f1") as FavoritesFragment?)?.callback = galleryCallback
        (fragment.childFragmentManager.findFragmentByTag("f1") as FavoritesFragment?)?.username = username
    }

    private fun createSubmissionsFragment() : SubmissionsFragment {
        val fragment = SubmissionsFragment.newInstance()
        fragment.callback = galleryCallback
        fragment.username = username
        return fragment
    }

    private fun createFavoritesFragment() : FavoritesFragment {
        val fragment = FavoritesFragment.newInstance()
        fragment.callback = galleryCallback
        fragment.username = username
        return fragment
    }

}