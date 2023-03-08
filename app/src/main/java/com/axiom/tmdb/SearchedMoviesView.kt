package com.axiom.tmdb

import android.content.Context
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchedMoviesView(context: Context) : LinearLayout(context) {
    var title=TextView(context)
    var recyclerView= RecyclerView(context)
    init{
        orientation = VERTICAL

        addView(title)
        recyclerView.layoutParams =
            LinearLayout.LayoutParams(MATCH_PARENT,MATCH_PARENT)
        addView(recyclerView)
        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT,MATCH_PARENT)
    }
}