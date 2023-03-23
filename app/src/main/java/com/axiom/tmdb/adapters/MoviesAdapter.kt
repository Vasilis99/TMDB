package com.axiom.tmdb.adapters


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.axiom.tmdb.FavoriteManager
import com.axiom.tmdb.TMDB
import com.axiom.tmdb.views.RecyclerViewItemView
import com.axiomc.tmdb.R

class MoviesAdapter(var movies: List<TMDB.MovieBasic>, var favorites: FavoriteManager, val clickListener: (Int) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    class MoviesViewHolder(val view: RecyclerViewItemView) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(RecyclerViewItemView(parent.context))
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.view.apply {
            if (position % 2 == 0) {
                holder.view.setBackgroundResource(R.color.gray_1)
            } else {
                holder.view.setBackgroundResource(R.color.gray_2)
            }
        }

        holder.view.image.load("https://image.tmdb.org/t/p/w342"+movies[position].poster_path)
        "${(position + 1)} ".also { holder.view.pos.text = it }
        holder.view.title.text=movies[position].title
        holder.view.rating.text=movies[position].vote_average.toString()
        holder.view.voteCount.text="Votes: "+movies[position].vote_count.toString()
        holder.view.overview.text=movies[position].overview
        for(x in favorites.getMoviesFavorites().value!!){
            if(x.first==movies[position].id){
                holder.view.favorite.isChecked=true
            }
        }
        var checkBox=holder.view.favorite
        checkBox.setOnClickListener{
            val movie=Triple(movies[position].id,movies[position].title,movies[position].poster_path)
            if(checkBox.isChecked) {
                favorites.addMovieFavorites(movie)
            }
            else{
                favorites.deleteMovieFavorites(movie)
            }
        }
        holder.itemView.setOnClickListener {
            clickListener(movies[position].id)
            println("Title pressed: " + (movies[position].title))
        }
    }

}