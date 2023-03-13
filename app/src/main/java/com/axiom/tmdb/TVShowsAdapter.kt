package com.axiom.tmdb

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TVShowsAdapter(var tvShowsDetails: TMDB.TVShows,var favorites: FavoriteManager, val clickListener: (Int)->Unit) : RecyclerView.Adapter<TVShowsAdapter.TVShowsViewHolder>() {


    class TVShowsViewHolder(val view:RecyclerViewItemView):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowsViewHolder {
        return TVShowsViewHolder(RecyclerViewItemView(parent.context))

    }


    override fun getItemCount(): Int {
        return tvShowsDetails.results.size
    }

    override fun onBindViewHolder(holder: TVShowsViewHolder, position: Int) {
        "${(position + 1)} ".also { holder.view.pos.text = it }
        holder.view.text.text=tvShowsDetails.results[position].name
        for(x in favorites.getTVShowsFavorites()){
            if(x==tvShowsDetails.results[position].id){
                holder.view.favorite.isChecked=true
            }
        }
        var checkBox=holder.view.favorite
        checkBox.setOnClickListener{
            if(checkBox.isChecked) {
                favorites.addTVShowFavorite(tvShowsDetails.results[position].id)
            }
            else{
                favorites.deleteTVShowFavorite(tvShowsDetails.results[position].id)
            }
        }
        holder.itemView.setOnClickListener {
            clickListener(tvShowsDetails.results[position].id)
            println("Title pressed: " + (tvShowsDetails.results[position].name))
        }

    }
}