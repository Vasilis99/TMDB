package com.axiom.tmdb

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axiomc.core.dslanguage.utility.Async.waitExec
import com.google.android.material.internal.ContextUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TopRatedMoviesFragment : Fragment() {

    lateinit var movies: MutableList<TMDB.MovieBasic>

    object RetrofitHelper {
        private const val baseUrl = "https://api.themoviedb.org/3/"
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movies = mutableListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.context.let {
        TopRatedMoviesView(it).apply {
            val myApi = RetrofitHelper.getInstance().create(MyApi::class.java)

            lifecycleScope.launchWhenResumed {
                var response = myApi.getTopRatedMovies("287f6ab6616e3724955e2b4c6841ea63", 1)
                var pages=response.body()!!.total_pages
                var result = response.body()!!.results
                for (x in result!!) {
                    movies.add(x)
                }
                var saved=FavoriteManager(context)
                moviesRecyclerView.layoutManager = LinearLayoutManager(context)
                moviesRecyclerView.adapter = MoviesAdapter(movies,saved) { movieID ->
                    var movieFragment: MovieFragment
                    for (x in movies) {
                        if (x.id == movieID) {
                            movieFragment = MovieFragment.newInstance(movieID)

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

    companion object {
        @JvmStatic
        fun newInstance() = TopRatedMoviesFragment()
    }


}