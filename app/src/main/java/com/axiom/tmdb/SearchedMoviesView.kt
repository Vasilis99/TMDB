package com.axiom.tmdb

import android.content.Context
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class SearchedMoviesView(context: Context) : LinearLayout(context) {
    var title = TextView(context)

    init {
        addView(title)
        layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            id = View.generateViewId()
        }
    }

}