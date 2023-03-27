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
import com.axiom.tmdb.MyApi
import com.axiom.tmdb.RetrofitHelper
import com.axiom.tmdb.TMDB
import com.axiom.tmdb.adapters.TVShowsAdapter
import com.axiom.tmdb.views.TopRatedTVShowsView
import com.axiomc.core.dslanguage.design.Recycler.onScrollBoundBot
import koleton.Koleton
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton


class TopRatedTVShowsFragment : Fragment() {
    lateinit var tvShows: MutableList<TMDB.TVShowBasic>
    lateinit var favorites:FavoriteManager
    var pageCount=1
    private var totalPages=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Top rated tvShow Fragment")
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
            val myApi = RetrofitHelper.getInstance().create(MyApi::class.java)
            lifecycleScope.launchWhenResumed {
                val response = myApi.getTopTVShows("287f6ab6616e3724955e2b4c6841ea63",1)
                totalPages=response.body()!!.total_pages
                var results = response.body()!!.results
                for (x in results!!) {
                    tvShows.add(x)
                }

                favorites=ViewModelProvider((activity as MainActivity))[FavoriteManager::class.java]
                var f=favorites
                tvShowsRecyclerView.layoutManager =
                    LinearLayoutManager(context)
                val skeletonLoader = Koleton.skeletonLoader(context)
                tvShowsRecyclerView.loadSkeleton(skeletonLoader)
                tvShowsRecyclerView.adapter =
                    TVShowsAdapter(tvShows, favorites,{ tvShowID ->
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
                    },{
                        tvShow->
                        f.addTVShowFavorites(tvShow)
                    },{ tvShow->
                        f.deleteTVShowFavorites(tvShow)
                    })
               tvShowsRecyclerView.hideSkeleton()
                tvShowsRecyclerView.onScrollBoundBot {

                    pageCount++
                    println("Page count $pageCount")
                    if(pageCount!=totalPages) {
                        lifecycleScope.launchWhenResumed {
                            tvShowsRecyclerView.loadSkeleton(skeletonLoader)
                            var listLength = tvShows.size
                            val resp =
                                myApi.getTopTVShows("287f6ab6616e3724955e2b4c6841ea63", pageCount)
                            var res = resp.body()!!.results
                            for (x in res!!) {
                                tvShows.add(x)
                            }
                            var adapter = (tvShowsRecyclerView.adapter as TVShowsAdapter)

                            adapter.listTVShows = tvShows
                            var diff = tvShows.size - listLength
                            adapter.notifyItemRangeChanged(listLength, diff)
                            tvShowsRecyclerView.hideSkeleton()
                        }
                    }
                }

                var favObserver= Observer<List<Triple<Int, String, String>>> {updated->
                    println("Updated "+updated)
                    var adapter=(tvShowsRecyclerView.adapter as TVShowsAdapter)
                    adapter.fav=updated
                    adapter.notifyDataSetChanged()
                }
                favorites.getTVShowsFavorites().observe(viewLifecycleOwner,favObserver)

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


