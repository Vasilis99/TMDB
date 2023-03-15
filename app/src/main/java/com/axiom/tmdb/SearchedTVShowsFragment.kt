package com.axiom.tmdb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchedTVShowsFragment:Fragment() {
    private lateinit var tvShows: MutableList<TMDB.TVShowBasic>
    //lateinit var topRatedMoviesRecyclerView: RecyclerView
    var searchTVShow:String=""
    object RetrofitHelper {
        private const val baseUrl = "https://api.themoviedb.org/3/search/"
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            if (it != null) {
                searchTVShow = it.getString("tvShow")!!
            }
        }
        tvShows= mutableListOf()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.context.let {
        SearchedTVShowsView(it).apply {
            val myApi = SearchedTVShowsFragment.RetrofitHelper.getInstance().create(MyApi::class.java)
            lifecycleScope.launchWhenResumed {
                var response= myApi.searchTVShow("287f6ab6616e3724955e2b4c6841ea63",searchTVShow)

                var results = response.body()!!.results
                for (x in results!!) {
                    tvShows.add(x)
                }
                var saved=FavoriteManager(context)
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter =
                    TVShowsAdapter(tvShows,saved) { tvShowID ->
                        for (x in tvShows) {
                            if (x.id == tvShowID) {
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

//                call.enqueue(object : Callback<TMDB.TVShows> {
//                    override fun onResponse(
//                        call: Call<TMDB.TVShows>,
//                        response: Response<TMDB.TVShows>
//                    ) {
//
//
//                    }
//
//                    override fun onFailure(call: Call<TMDB.TVShows>, t: Throwable) {
//
//                    }
//
//                })


            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance(tvShow: String) =
            SearchedTVShowsFragment().apply {
                arguments = Bundle().apply {
                    putString("tvShow",tvShow)
                }
            }
    }
}