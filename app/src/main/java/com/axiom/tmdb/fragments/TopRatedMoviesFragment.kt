package com.axiom.tmdb.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.axiom.tmdb.FavoriteManager
import com.axiom.tmdb.MainActivity
import com.axiom.tmdb.adapters.MoviesAdapter
import com.axiom.tmdb.MyApi
import com.axiom.tmdb.RetrofitHelper
import com.axiom.tmdb.TMDB
import com.axiom.tmdb.adapters.TVShowsAdapter
import com.axiom.tmdb.views.TopRatedMoviesView


class TopRatedMoviesFragment : Fragment() {

    lateinit var movies: MutableList<TMDB.MovieBasic>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Top rated movie")
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

                var favorites= ViewModelProvider((activity as MainActivity))[FavoriteManager::class.java]
                moviesRecyclerView.layoutManager =
                    LinearLayoutManager(context)
                moviesRecyclerView.adapter =
                    MoviesAdapter(movies, favorites){ movieID ->
                        for (x in movies) {
                            if (x.id == movieID) {
                                println(movieID)
                                var moviesFragment = TVShowFragment.newInstance(movieID)

                                (activity as? MainActivity)?.myLayout?.id?.let { it1 ->

                                    var transaction =
                                        activity?.supportFragmentManager?.beginTransaction()
                                    transaction?.replace(it1, moviesFragment)?.commit()
                                    transaction?.addToBackStack(null)
                                }
                                break
                            }
                        }
                    }


                var favObserver= Observer<List<Triple<Int, String, String>>> {updated->
                    println("Updated "+updated)
                    var adapter=(moviesRecyclerView.adapter as MoviesAdapter)
                    //adapter.fav=updated
                    adapter.notifyDataSetChanged()
                }
                favorites.getMoviesFavorites().observe(viewLifecycleOwner,favObserver)

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = TopRatedMoviesFragment()
    }


}