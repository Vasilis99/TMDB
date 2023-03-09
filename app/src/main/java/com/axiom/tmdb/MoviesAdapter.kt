package com.axiom.tmdb


import android.graphics.Color
import android.text.Html
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(var moviesDetails: TMDB.Movies, val clickListener: (Int) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    class MoviesViewHolder(val view: RecyclerViewItemView) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(RecyclerViewItemView(parent.context))
    }


    override fun getItemCount(): Int {

        return moviesDetails.results.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        "${(position + 1)} ".also { holder.view.pos.text = it }
        holder.view.text.text = moviesDetails.results[position].title
        holder.itemView.setOnClickListener {
            clickListener(moviesDetails.results[position].id)
            println("Title pressed: " + (moviesDetails.results[position].title))
        }

    }
}