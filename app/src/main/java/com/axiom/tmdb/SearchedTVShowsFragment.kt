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
    private lateinit var tvShows: TMDB.TVShows
    //lateinit var topRatedMoviesRecyclerView: RecyclerView
    var tvShow:String=""
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
        arguments.let{
            if (it != null) {
                tvShow=it.getString("tvShow")!!
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.context.let {
        SearchedTVShowView(it).apply {
            val myApi = SearchedTVShowsFragment.RetrofitHelper.getInstance().create(MyApi::class.java)
            lifecycleScope.launchWhenResumed {
                var call= myApi.searchTVShow("287f6ab6616e3724955e2b4c6841ea63",tvShow)
                call.enqueue(object : Callback<TMDB.TVShows> {
                    override fun onResponse(
                        call: Call<TMDB.TVShows>,
                        response: Response<TMDB.TVShows>
                    ) {
                        tvShows= response.body()!!
                        println(tvShows.results.size.toString()+"Ti ginete dame"+tvShow)
                        recyclerView.layoutManager = LinearLayoutManager(context)
                        recyclerView.adapter =
                            TVShowsAdapter(tvShows) { tvShowID ->
                                for (x in tvShows.results) {
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


                    }

                    override fun onFailure(call: Call<TMDB.TVShows>, t: Throwable) {

                    }

                })


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