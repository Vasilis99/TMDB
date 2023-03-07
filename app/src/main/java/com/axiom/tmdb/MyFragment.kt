package com.axiom.tmdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.context.let {
        MyView(it).apply {
            var vpAdapter = VPAdapter(this@MyFragment)
            viewPager.adapter = vpAdapter

            TabLayoutMediator(
                tabLayout, viewPager
            ) { tab, position ->
                when (position) {
                    0 -> tab.text = "Search Movies-TV Shows"
                    1 -> tab.text = "Top Rated Shows"
                    2 -> tab.text = "Top Rated Movies"
                }
            }.attach()
        }
    }
}