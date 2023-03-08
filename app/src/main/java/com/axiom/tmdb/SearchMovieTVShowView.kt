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
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axiomc.core.components.text.AxiomEditText

/**
 * TODO: document your custom view class.
 */
class SearchMovieTVShowView(context: Context) : ScrollView(context) {
    var conLayout = ConstraintLayout(context)
    var linLayout = LinearLayout(context)
    private val label = TextView(context).apply {
        text = "Search Movies-TV Shows"
        textSize = 30F
    }
    private var topRatedMoviesRecyclerView = RecyclerView(context)
    var movieInputBox = AxiomEditText(context)
    var movieButton = Button(context)
    var tvShowInputBox = AxiomEditText(context)
    var tvShowButton = Button(context)

    init {
        layoutParams=LayoutParams(MATCH_PARENT, MATCH_PARENT).apply {
            id=View.generateViewId()
        }
        addView(linLayout)
        linLayout.apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
            }
            addView(label)
            addView(conLayout)
        }

        conLayout.apply {
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
            }
        }
        movieInputBox.apply {
            layoutParams = ConstraintLayout.LayoutParams(400, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToTop = conLayout.id
                startToStart = conLayout.id
                endToStart = tvShowInputBox.id
            }
        }
        conLayout.addView(movieInputBox)
        tvShowInputBox.apply {
            layoutParams = ConstraintLayout.LayoutParams(400, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToTop = conLayout.id
                startToEnd = movieInputBox.id
                endToEnd = conLayout.id
            }
        }
        conLayout.addView(tvShowInputBox)

        movieButton.apply {
            text="Search Movie"
            layoutParams = ConstraintLayout.LayoutParams(400, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = movieInputBox.id
                startToStart = conLayout.id
                endToEnd = tvShowButton.id
            }
        }
        conLayout.addView(movieButton)

        tvShowButton.apply {
            text = "Search TV Show"
            layoutParams = ConstraintLayout.LayoutParams(400, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = tvShowInputBox.id
                startToEnd = movieButton.id
                endToEnd = conLayout.id
            }
        }
        conLayout.addView(tvShowButton)
    }
}