package com.axiom.tmdb


import android.graphics.Color
import android.text.Html
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(var moviesDetails: TMDB.Movies,val clickListener: (Int)->Unit) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    class MoviesViewHolder(val view:TextView):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        var title= TextView(parent.context).apply{
            textSize= 20F
            setTextColor(Color.BLACK)
        }
        return MoviesViewHolder(title)

    }


    override fun getItemCount(): Int {

        return moviesDetails.results.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.view.text= Html.fromHtml("<p><b>${position+1}</b>${" "+moviesDetails.results[position].title}</p>",1)
        holder.itemView.setOnClickListener {
           clickListener(moviesDetails.results[position].id)
            println("Title pressed: " + (moviesDetails.results[position].title))
        }

    }
}