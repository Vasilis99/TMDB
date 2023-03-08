package com.axiom.tmdb

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


import android.content.Context;
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.service.autofill.FieldClassification.Match
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
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