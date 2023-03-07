package com.axiom.tmdb


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load

class MovieAdapter(var moviesDetails: TMDB.MovieBasic,var movieGenres: List<TMDB.GenrePair>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    class MovieViewHolder(val view:MoviesDetailItem):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(MoviesDetailItem(parent.context))

    }


    override fun getItemCount(): Int {
        return 13
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.view.apply { 
        when(position){
            0-> {
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "Adult"
                text.text = moviesDetails.adult.toString()

            }
            1-> {
                text.visibility=View.INVISIBLE
                image.visibility=View.VISIBLE
                title.text = "backdrop_path"
                //var url="https://image.tmdb.org/t/p/w500"+moviesDetails.backdrop_path
                //image.load(url)
                image.setImageResource(R.drawable.ic_launcher_background)
            }
            2->{
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "Genres"
                var genres =""
                for(x in movieGenres){
                    if(x.id==moviesDetails.genre_ids[0])
                        genres=genres+""+x.name+"\n"
                }
                for(x in movieGenres){
                    if(x.id==moviesDetails.genre_ids[1])
                        genres=genres+""+x.name
                }
                text.text = genres

            }
            3-> {
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "id"
                text.text = moviesDetails.id.toString()
            }
            4->{
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "original_language"
                text.text = moviesDetails.original_language

            }
            5->{
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "original_title"
                text.text = moviesDetails.original_title
                removeView(image)
            }
            6->{
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "overview"
                text.text = moviesDetails.overview
                removeView(image)
            }
            7->{
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "popularity"
                text.text = moviesDetails.popularity.toString()
                removeView(image)
            }
            8->{
                text.visibility=View.INVISIBLE
                image.visibility=View.VISIBLE
                title.text = "poster_image"
                var url="https://image.tmdb.org/t/p/w500"+moviesDetails.poster_path
                image.load(url)
            }
            9->{
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "release_date"
                text.text = moviesDetails.release_date
                removeView(image)
            }
            10->{
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "video"
                text.text = moviesDetails.video.toString()
                removeView(image)
            }
            11->{
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "vote_average"
                text.text = moviesDetails.vote_average.toString()
                removeView(image)
            }
            12->{
                text.visibility=View.VISIBLE
                image.visibility=View.INVISIBLE
                title.text = "vote_count"
                text.text = moviesDetails.vote_count.toString()
                removeView(image)
            }
        }
        }

    }
}

