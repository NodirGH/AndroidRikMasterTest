package com.example.androidrikmastertest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidrikmastertest.ui.CameraFragment
import com.example.androidrikmastertest.ui.DoorFragment

class TabLayoutAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            CameraFragment()
        } else {
            DoorFragment()
        }
    }
}