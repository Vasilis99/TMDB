package com.axiom.tmdb

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * TODO: document your custom view class.
 */
class SearchMovieTVShowView (context:Context) : ConstraintLayout(context){

    private val label = TextView(context).apply { text = "Search Movies-TV Shows"
        textSize= 30F
    }
    private var topRatedMoviesRecyclerView = RecyclerView(context)

    init{
        addView(label)

    }
}