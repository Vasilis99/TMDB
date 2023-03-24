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
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color

class TopRatedMoviesView(context: Context) : ConstraintLayout(context) {
    private val title =
        TextView(context).applyId().bold().color(Color.BLACK).text("Top rated Movies").size(20)

    public val moviesRecyclerView = RecyclerView(context)


    init {

        applyId()
        layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        title.layoutParams =
            ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToTop = this@TopRatedMoviesView.id
                startToStart = this@TopRatedMoviesView.id
                endToEnd = this@TopRatedMoviesView.id
            }
        addView(title)
        moviesRecyclerView.layoutParams =
            ConstraintLayout.LayoutParams(MATCH_PARENT, 0).apply {
                topToBottom = title.id
                startToStart = this@TopRatedMoviesView.id
                endToEnd = this@TopRatedMoviesView.id
                bottomToBottom = this@TopRatedMoviesView.id
                setMargins(0, dp(20), 0, 0)
            }
        moviesRecyclerView.addItemDecoration(MyItemDecoration(20))

        addView(moviesRecyclerView)

    }
}