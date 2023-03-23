package com.axiom.tmdb.views

import android.widget.TextView


import android.content.Context;
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class TopRatedMoviesView(context: Context) : LinearLayout(context) {
    private val label = TextView(context).apply {
        text = "TopRatedMoviesView"
        textSize = 30F
    }
    public val moviesRecyclerView = RecyclerView(context)


    init {
        orientation = VERTICAL

        addView(label)
        moviesRecyclerView.layoutParams =
            LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        //topRatedMoviesRecyclerView.background= ColorDrawable(Color.BLUE)
        addView(moviesRecyclerView)
        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)

    }
}