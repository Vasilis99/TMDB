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
    private lateinit var tvShowsDetails: TMDB.TopRatedTVShows
    lateinit var topRatedTVShowsRecyclerView: RecyclerView

    object RetrofitHelper {
        private const val baseUrl = "https://api.themoviedb.org/3/"
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
        TopRatedTVShowsView(it).apply {
            val myApi = TopRatedTVShowsFragment.RetrofitHelper.getInstance().create(MyApi::class.java)
            lifecycleScope.launchWhenResumed {
                val response1 = myApi.getTopTVShows()
                tvShowsDetails = response1.body()!!
                topRatedTVShowsRecyclerView.layoutManager = LinearLayoutManager(context)
                topRatedTVShowsRecyclerView.adapter =
                    TopRatedTVShowsAdapter(tvShowsDetails) { tvShowID ->
                        for (x in tvShowsDetails.results) {
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

    companion object {
        @JvmStatic
        fun newInstance() =
            TopRatedTVShowsFragment()
    }
}