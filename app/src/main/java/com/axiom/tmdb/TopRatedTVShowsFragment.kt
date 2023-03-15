package com.axiom.tmdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TopRatedTVShowsFragment : Fragment() {
    private lateinit var tvShows: MutableList<TMDB.TVShowBasic>


    object RetrofitHelper {
        private const val baseUrl = "https://api.themoviedb.org/3/"
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            println("einai null")
        }
        else{
            println("NOOOOO")
        }
        tvShows= mutableListOf()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.context.let {
        TopRatedTVShowsView(it).apply {
            val myApi = TopRatedTVShowsFragment.RetrofitHelper.getInstance().create(MyApi::class.java)
            lifecycleScope.launchWhenResumed {
                val response = myApi.getTopTVShows()
                var results = response.body()!!.results
                for (x in results!!) {
                    tvShows.add(x)
                }
                var saved=FavoriteManager(context)
                tvShowsRecyclerView.layoutManager = LinearLayoutManager(context)
                tvShowsRecyclerView.adapter =
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
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    companion object {
        @JvmStatic
        fun newInstance() =
            TopRatedTVShowsFragment()
    }
}