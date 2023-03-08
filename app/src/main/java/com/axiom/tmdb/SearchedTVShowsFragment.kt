package com.axiom.tmdb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchedTVShowsFragment:Fragment() {
    private lateinit var moviesDetails: TMDB.TopRatedMovies
    lateinit var topRatedMoviesRecyclerView: RecyclerView
    object RetrofitHelper {
        private const val baseUrl = "https://api.themoviedb.org/3/search/"
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.context.let {
        SearchedTVShowView(it).apply {
            val myApi = SearchedTVShowsFragment.RetrofitHelper.getInstance().create(MyApi::class.java)
//            lifecycleScope.launchWhenResumed {
//                val response1 = myApi.searchTVShow()
//               // moviesDetails = response1.body()!!
//                topRatedMoviesRecyclerView.layoutManager = LinearLayoutManager(context)
//                topRatedMoviesRecyclerView.adapter =
//                    TopRatedMoviesAdapter(moviesDetails) { movieID ->
//                        var movieFragment: MovieFragment
//                        for (x in moviesDetails.results) {
//                            if (x.id == movieID) {
//                                movieFragment = MovieFragment.newInstance(movieID)
//
//                                (activity as? MainActivity)?.myLayout?.id?.let { it1 ->
//
//                                    var transaction =
//                                        activity?.supportFragmentManager?.beginTransaction()
//                                    transaction?.replace(it1, movieFragment)?.commit()
//                                    transaction?.addToBackStack(null)
//                                }
//                                break
//                            }
//                        }
//                    }

//            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}