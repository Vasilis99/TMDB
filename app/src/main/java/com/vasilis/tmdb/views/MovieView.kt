package com.vasilis.tmdb.views

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.vasilis.tmdb.MyItemDecoration
import com.vasilis.tmdb.views.shimmer.MovieShimmer

class MovieView(context: Context) : ConstraintLayout(context) {
    var movieMap: MutableMap<String, View> = mutableMapOf<String, View>()
    var recyclerView = RecyclerView(context).apply{id=View.generateViewId()}
    var movieShimmer=MovieShimmer(context)

    init {
        apply{id=View.generateViewId()}
        this.setBackgroundColor(Color.WHITE)
        recyclerView.layoutParams= LayoutParams(MATCH_PARENT, MATCH_PARENT)
        recyclerView.addItemDecoration(MyItemDecoration(10,10,0,dp(20)))


        movieMap["title"] = TextView(context).apply{id=View.generateViewId()}.color(Color.BLACK).bold().size(22)
        movieMap["adult"] = TitleDescriptionView(context).vertical()
        movieMap["backdrop"] = ImageView(context).apply{id=View.generateViewId()}
        movieMap["collection"] = CollectionView(context)
        movieMap["budget"] = TitleDescriptionView(context).vertical()
        movieMap["genres"] = TitleDescriptionView(context).vertical()
        movieMap["homepage"] = TitleDescriptionView(context).vertical()
        movieMap["movieID"] = TitleDescriptionView(context).vertical()
        movieMap["originalLanguage"] = TitleDescriptionView(context).vertical()
        movieMap["overview"] = TitleDescriptionView(context).vertical()
        movieMap["popularity"] = TitleDescriptionView(context).vertical()
        movieMap["posterImage"] = ImageView(context).apply{id=View.generateViewId()}
        movieMap["productionCompanies"] = SpecialView(context)
        movieMap["productionCountries"] = TitleDescriptionView(context).vertical()
        movieMap["releaseDate"] = TitleDescriptionView(context).vertical()
        movieMap["revenue"] = TitleDescriptionView(context).vertical()
        movieMap["runtime"] = TitleDescriptionView(context).vertical()
        movieMap["spokenLanguages"] = TitleDescriptionView(context).vertical()
        movieMap["status"] = TitleDescriptionView(context).vertical()
        movieMap["tagline"] = TitleDescriptionView(context).vertical()
        movieMap["voteAverage"] = TitleDescriptionView(context).vertical()
        movieMap["voteCount"] = TitleDescriptionView(context).vertical()
        movieMap["reviewsButton"] = Button(context).text("Reviews").apply{id=View.generateViewId()}

        recyclerView.vLinear.lazyAdd{
            movieMap.forEach {
                if(it.key=="backdrop"){
                    add(it.value.bind {
                        height= 596
                        width= MATCH_PARENT
                    })
                }
                else{
                    add(it.value)
                }

            }
        }
        addView(recyclerView)
        recyclerView.visibility= INVISIBLE
        addView(movieShimmer)
    }
}