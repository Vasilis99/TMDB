package com.axiom.tmdb.views.shimmer

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.axiom.tmdb.MyItemDecoration
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color
import com.facebook.shimmer.ShimmerFrameLayout

class FavoritesShimmer(context: Context): ShimmerFrameLayout(context){
    var tvShowsTitle= TextView(context).text("Favorite TV Shows").color(Color.BLACK).size(20).applyId()
    var tvShowsRecyclerView= RecyclerView(context).applyId()
    var moviesTitle= TextView(context).text("Favorite Movies").color(Color.BLACK).size(20).applyId()
    var moviesRecyclerView= RecyclerView(context).applyId()
    var conLayout=ConstraintLayout(context).applyId()
    init {
        applyId()
        tvShowsTitle.apply {
            layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                setMargins(20, 0,20,0)
                topToTop = conLayout.id
                startToStart = conLayout.id
                endToEnd = conLayout.id
                setBackgroundColor(Color.GRAY)
            }
        }
        tvShowsRecyclerView.apply {
            layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 800).apply {
                topToBottom = tvShowsTitle.id
                startToStart = conLayout.id
                endToEnd = conLayout.id
                setBackgroundColor(Color.GRAY)
            }
        }
        tvShowsRecyclerView.addItemDecoration(MyItemDecoration(10,10,10,0))
        moviesTitle.apply {
            layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                setMargins(20, 20,20,20)
                topToBottom = tvShowsRecyclerView.id
                startToStart = conLayout.id
                endToEnd = conLayout.id
                setBackgroundColor(Color.GRAY)
            }
        }
        moviesRecyclerView.apply {
            layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 800).apply {
                topToBottom = moviesTitle.id
                startToStart = conLayout.id
                endToEnd = conLayout.id
                setBackgroundColor(Color.GRAY)
            }
        }
        moviesRecyclerView.addItemDecoration(MyItemDecoration(20,20,10,0))

        conLayout.addView(tvShowsTitle)
        conLayout.addView(tvShowsRecyclerView)
        conLayout.addView(moviesTitle)
        conLayout.addView(moviesRecyclerView)



    }
}