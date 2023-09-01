package com.example.androidrikmastertest.ui

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.androidrikmastertest.R
import com.example.androidrikmastertest.adapter.TabLayoutAdapter
import com.example.androidrikmastertest.base.BaseFragment
import com.example.androidrikmastertest.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private lateinit var tabLayoutAdapter: TabLayoutAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTabLayout()

    }

    private fun setTabLayout() {
        tabLayoutAdapter =
            TabLayoutAdapter(requireActivity().supportFragmentManager, requireActivity().lifecycle)

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.Camera))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.Door))

        binding.vpStatisticPage.adapter = tabLayoutAdapter

        binding.vpStatisticPage.isUserInputEnabled = false

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab == null) return

                binding.vpStatisticPage.currentItem = tab.position
                if (tab.position == 0) {
//                    isReadTime = true
//                    isListenTime = false
                } else {
//                    isReadTime = false
//                    isListenTime = true
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        binding.vpStatisticPage.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })
    }
}