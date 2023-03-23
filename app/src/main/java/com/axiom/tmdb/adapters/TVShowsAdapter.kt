package com.axiom.tmdb.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.axiom.tmdb.FavoriteManager
import com.axiom.tmdb.TMDB
import com.axiom.tmdb.views.RecyclerViewItemView
import com.axiomc.core.dslanguage.utility.List.find
import com.axiomc.tmdb.R

class TVShowsAdapter(
    var tvShows: List<TMDB.TVShowBasic>,
    var favorites: FavoriteManager,
    val clickListener: (Int) -> Unit,
    val add: (Triple<Int, String, String>) -> Unit,
    val del: (Triple<Int, String, String>) -> Unit
) : RecyclerView.Adapter<TVShowsAdapter.TVShowsViewHolder>() {
    var fav = favorites.getTVShowsFavorites().value!!


    class TVShowsViewHolder(val view: RecyclerViewItemView) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowsViewHolder {
        return TVShowsViewHolder(RecyclerViewItemView(parent.context))
    }


    override fun getItemCount(): Int {
        return tvShows.size
    }

    override fun onBindViewHolder(holder: TVShowsViewHolder, position: Int) {
        holder.view.apply {
            if (position % 2 == 0) {
                holder.view.setBackgroundResource(R.color.gray_1)
            } else {
                holder.view.setBackgroundResource(R.color.gray_2)
            }
        }

        holder.view.image.load("https://image.tmdb.org/t/p/w342" + tvShows[position].poster_path)
        "${(position + 1)} ".also { holder.view.pos.text = it }
        holder.view.title.text = tvShows[position].name
        holder.view.rating.text = tvShows[position].vote_average.toString()
        holder.view.voteCount.text = "Votes: " + tvShows[position].vote_count.toString()
        holder.view.overview.text = tvShows[position].overview
        holder.view.favorite.isChecked = fav.find { it.first==tvShows[position].id } != null



        var checkBox = holder.view.favorite
        checkBox.setOnClickListener {
            val tvShow =
                Triple(tvShows[position].id, tvShows[position].name, tvShows[position].poster_path)
            if (checkBox.isChecked) {
                add(tvShow)
            } else {

                del(tvShow)
            }
        }
        holder.itemView.setOnClickListener {
            clickListener(tvShows[position].id)
            println("Title pressed: " + (tvShows[position].name))
        }
    }
}