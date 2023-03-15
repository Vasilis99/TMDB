package com.axiom.tmdb

import android.content.Context
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchedTVShowsView(context: Context):LinearLayout(context) {
    var title=TextView(context)
    var recyclerView=RecyclerView(context)
    init{
        layoutParams = LayoutParams(MATCH_PARENT,MATCH_PARENT)
        orientation = VERTICAL

        addView(title)
        recyclerView.layoutParams =
            LinearLayout.LayoutParams(MATCH_PARENT,MATCH_PARENT)
        addView(recyclerView)

    }
}