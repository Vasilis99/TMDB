package com.axiom.tmdb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

class FavoritesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FavoritesView(inflater.context).apply {
        var saved=FavoriteManager(context)
        var tvShows=saved.getMoviesFavorites()
        tvShowsRecyclerView.layoutManager = LinearLayoutManager(context)
        var temp:MutableList<TMDB.TVShowBasic> = mutableListOf()
        tvShowsRecyclerView.adapter =
            TVShowsAdapter(temp,saved) { tvShowID ->
                for (x in tvShows) {
                    if (x == tvShowID) {
                        println(tvShowID)
                        var tvShowFragment = TVShowFragment.newInstance(tvShowID)

                        (activity as? MainActivity)?.myLayout?.id?.let { it1 ->

                            var transaction =
                                activity?.supportFragmentManager?.beginTransaction()
                            transaction?.replace(it1, tvShowFragment)?.commit()
                            transaction?.addToBackStack(null)
                        }
                        break
                    }
                }
            }
    }
}
