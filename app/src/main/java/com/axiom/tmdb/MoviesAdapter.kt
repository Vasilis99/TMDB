package com.axiom.tmdb


import android.graphics.Color
import android.text.Html
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(var movies: List<TMDB.MovieBasic>, var favorites:FavoriteManager, val clickListener: (Int) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    class MoviesViewHolder(val view: RecyclerViewItemView) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(RecyclerViewItemView(parent.context))
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        "${(position + 1)} ".also { holder.view.pos.text = it }
        holder.view.text.text = movies[position].title
        for(x in favorites.getMoviesFavorites()){
            if(x==movies[position].id){
                holder.view.favorite.isChecked=true
            }
        }
        var checkBox=holder.view.favorite
        checkBox.setOnClickListener{
            if(checkBox.isChecked) {
                favorites.addMovieFavorite(movies[position].id)
            }
            else{
                favorites.deleteMovieFavorite(movies[position].id)
            }
        }
        holder.itemView.setOnClickListener {
            clickListener(movies[position].id)
            println("Title pressed: " + (movies[position].title))
        }

    }
}