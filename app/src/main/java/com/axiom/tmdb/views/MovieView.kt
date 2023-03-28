package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.net.LinkAddress
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.axiom.tmdb.MyItemDecoration
import com.axiomc.core.components.generic.LazyConcat.bind
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Recycler.lazyAdd
import com.axiomc.core.dslanguage.design.Recycler.vLinear
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color
import com.axiomc.core.dslanguage.utility.Layout.margins


class MovieView(context: Context) : ConstraintLayout(context) {
    var movieMap: MutableMap<String, View> = mutableMapOf<String, View>()
    var recyclerView = RecyclerView(context).applyId()

    init {
        applyId()
        recyclerView.layoutParams= LayoutParams(MATCH_PARENT, MATCH_PARENT)
        recyclerView.addItemDecoration(MyItemDecoration(10,10,dp(20)))


        movieMap["title"] = TextView(context).applyId().color(Color.BLACK).bold().size(22)
        movieMap["adult"] = TitleDescriptionView(context).vertical()
        movieMap["backdrop"] = ImageView(context).applyId()
        movieMap["collection"] = CollectionView(context)
        movieMap["budget"] = TitleDescriptionView(context).vertical()
        movieMap["genres"] = TitleDescriptionView(context).vertical()
        movieMap["homepage"] = TitleDescriptionView(context).vertical()
        movieMap["movieID"] = TitleDescriptionView(context).vertical()
        movieMap["originalLanguage"] = TitleDescriptionView(context).vertical()
        movieMap["overview"] = TitleDescriptionView(context).vertical()
        movieMap["popularity"] = TitleDescriptionView(context).vertical()
        movieMap["posterImage"] = ImageView(context).applyId()
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
        movieMap["reviewsButton"] = Button(context).text("Reviews").applyId()

        recyclerView.vLinear.lazyAdd{
            movieMap.forEach {
                add(it.value)
            }
        }
        addView(recyclerView)
    }
}