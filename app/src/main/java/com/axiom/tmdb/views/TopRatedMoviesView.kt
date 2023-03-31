package com.axiom.tmdb.views

import android.widget.TextView


import android.content.Context;
import android.graphics.Color
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.axiom.tmdb.MyItemDecoration
import com.axiom.tmdb.views.shimmer.RecyclerViewShimmer
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color

class TopRatedMoviesView(context: Context) : ConstraintLayout(context) {
    val title =
        TextView(context).applyId().bold().color(Color.BLACK).text("Top rated Movies").size(20)

    public val moviesRecyclerView = RecyclerView(context).applyId()
    public val shimmer=RecyclerViewShimmer(context).applyId()

    init {

        applyId()
        setBackgroundColor(Color.WHITE)
        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
        title.layoutParams =
            LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToTop = this@TopRatedMoviesView.id
                startToStart = this@TopRatedMoviesView.id
                endToEnd = this@TopRatedMoviesView.id
                setMargins(20,0,20,0)
            }
        addView(title)
        moviesRecyclerView.layoutParams =
            LayoutParams(MATCH_PARENT, 0).apply {
                topToBottom = title.id
                startToStart = this@TopRatedMoviesView.id
                endToEnd = this@TopRatedMoviesView.id
                bottomToBottom = this@TopRatedMoviesView.id

            }
        moviesRecyclerView.addItemDecoration(MyItemDecoration(20,20,20,0))

        shimmer.layoutParams =
            LayoutParams(MATCH_PARENT, 0).apply {
                topToBottom=title.id
                startToStart=this@TopRatedMoviesView.id
                endToEnd=this@TopRatedMoviesView.id
                bottomToBottom=this@TopRatedMoviesView.id
            }
        moviesRecyclerView.visibility= INVISIBLE
        addView(moviesRecyclerView)
        addView(shimmer)



    }
}