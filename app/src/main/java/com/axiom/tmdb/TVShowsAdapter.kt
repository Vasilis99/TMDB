package com.axiom.tmdb

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TVShowsAdapter(var tvShows: List<TMDB.TVShowBasic>,var favorites: FavoriteManager, val clickListener: (Int)->Unit) : RecyclerView.Adapter<TVShowsAdapter.TVShowsViewHolder>() {


    class TVShowsViewHolder(val view:RecyclerViewItemView):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowsViewHolder {
        return TVShowsViewHolder(RecyclerViewItemView(parent.context))

    }


    override fun getItemCount(): Int {
        return tvShows.size
    }

    override fun onBindViewHolder(holder: TVShowsViewHolder, position: Int) {
        "${(position + 1)} ".also { holder.view.pos.text = it }
        holder.view.text.text=tvShows[position].name
        for(x in favorites.getTVShowsFavorites()){
            if(x==tvShows[position].id){
                holder.view.favorite.isChecked=true
            }
        }
        var checkBox=holder.view.favorite
        checkBox.setOnClickListener{
            if(checkBox.isChecked) {
                favorites.addTVShowFavorite(tvShows[position].id)
            }
            else{
                favorites.deleteTVShowFavorite(tvShows[position].id)
            }
        }
        holder.itemView.setOnClickListener {
            clickListener(tvShows[position].id)
            println("Title pressed: " + (tvShows[position].name))
        }

    }
}