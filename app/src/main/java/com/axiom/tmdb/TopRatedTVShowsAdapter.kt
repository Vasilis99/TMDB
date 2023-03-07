package com.axiom.tmdb

import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.widget.TextView

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class TopRatedTVShowsAdapter(var tvShowsDetails: TMDB.TopRatedTVShows,val clickListener: (Int)->Unit) : RecyclerView.Adapter<TopRatedTVShowsAdapter.TopRatedTVShowsViewHolder>() {


    class TopRatedTVShowsViewHolder(val view:TopRatedMoviesItemView):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedTVShowsViewHolder {
        return TopRatedTVShowsViewHolder(TopRatedMoviesItemView(parent.context))

    }


    override fun getItemCount(): Int {
        return tvShowsDetails.results.size
    }

    override fun onBindViewHolder(holder: TopRatedTVShowsViewHolder, position: Int) {
        println(position)
        holder.view.pos.text= "$position "
        holder.view.text.text=tvShowsDetails.results[position].name
        holder.itemView.setOnClickListener {
            clickListener(tvShowsDetails.results[position].id)
            println("Title pressed: " + (tvShowsDetails.results[position].name))
        }

    }
}