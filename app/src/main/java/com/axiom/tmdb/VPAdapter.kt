package com.axiom.tmdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter


    class VPAdapter(fragmentActivity: Fragment): FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 3;
        }

        override fun createFragment(position: Int): Fragment {
            var fragment:Fragment = when(position){
                1 -> TopRatedTVShowsFragment()
                2 -> TopRatedMoviesFragment()
                else -> SearchMovieTVShowFragment()
            }
            return fragment
        }


    }