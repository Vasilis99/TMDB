package com.axiom.tmdb

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class TopRatedTVShowsView(context: Context) : LinearLayout(context) {
    private val label = TextView(context).apply {
        text = "TopTVShowsView"
        textSize = 30F
    }
    public val tvShowsRecyclerView = RecyclerView(context)


    init {
        orientation = VERTICAL

        addView(label)
        tvShowsRecyclerView.layoutParams =
            LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)

        addView(tvShowsRecyclerView)
        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)

    }

}