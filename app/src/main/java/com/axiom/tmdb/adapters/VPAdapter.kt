package com.axiom.tmdb.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.axiom.tmdb.fragments.FavoritesFragment
import com.axiom.tmdb.fragments.SearchMovieTVShowFragment
import com.axiom.tmdb.fragments.TopRatedMoviesFragment
import com.axiom.tmdb.fragments.TopRatedTVShowsFragment


class VPAdapter(fragmentActivity: Fragment): FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 4;
        }

        override fun createFragment(position: Int): Fragment {
            var fragment:Fragment = when(position){
                0 -> TopRatedTVShowsFragment()
                1 -> TopRatedMoviesFragment()
                2 -> SearchMovieTVShowFragment()
                else -> FavoritesFragment()

            }
            return fragment
        }


    }