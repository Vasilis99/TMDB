package com.axiom.tmdb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchedMoviesFragment:Fragment() {
    lateinit var movies: MutableList<TMDB.MovieBasic>
    var searchMovie=""
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
        arguments?.let {
            searchMovie=it.getString("searchMovie")!!
        }
        movies = mutableListOf()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.context.let {
        SearchedTVShowsView(it).apply {
            val myApi = SearchedTVShowsFragment.RetrofitHelper.getInstance().create(MyApi::class.java)
            lifecycleScope.launchWhenResumed {
                var response= myApi.searchMovie("287f6ab6616e3724955e2b4c6841ea63",searchMovie)
                var pages=response.body()!!.total_pages
                var result = response.body()!!.results
                for (x in result!!) {
                    movies.add(x)
                }
                var saved=FavoriteManager(context)
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter =
                    MoviesAdapter(movies,saved) {movieID ->
                        for (x in movies) {
                            if (x.id == movieID) {
                                println(movieID)
                                var movieFragment = MovieFragment.newInstance(movieID)

                                (activity as? MainActivity)?.myLayout?.id?.let { it1 ->

                                    var transaction =
                                        activity?.supportFragmentManager?.beginTransaction()
                                    transaction?.replace(it1, movieFragment)?.commit()
                                    transaction?.addToBackStack(null)
                                }
                                break
                            }
                        }
                    }
            }
        }
    }
    companion object{
        @JvmStatic
        fun newInstance(searchMovie: String) =
            SearchedMoviesFragment().apply {
                arguments = Bundle().apply {
                    putString("searchMovie",searchMovie)
                }
            }
    }
}