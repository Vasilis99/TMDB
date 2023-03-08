package com.axiom.tmdb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SearchedMoviesFragment:Fragment() {
    var searchMovie=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            searchMovie=it.getString("searchMovie")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return SearchedMoviesView(inflater.context)
    }
    companion object{
        @JvmStatic
        fun newInstance(searchMovie: String) =
            SearchMovieTVShowFragment().apply {
                arguments = Bundle().apply {
                    putString("searchMovie",searchMovie)
                }
            }
    }
}