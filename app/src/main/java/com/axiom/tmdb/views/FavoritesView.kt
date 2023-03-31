package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.axiom.tmdb.MyItemDecoration
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color

class FavoritesView(context: Context):ConstraintLayout(context){
    var tvShowsTitle=TextView(context).text("Favorite TV Shows").color(Color.BLACK).size(20).applyId()
    var tvShowsRecyclerView=RecyclerView(context).applyId()
    var moviesTitle=TextView(context).text("Favorite Movies").color(Color.BLACK).size(20).applyId()
    var moviesRecyclerView=RecyclerView(context).applyId()
    init {
        applyId()
        tvShowsTitle.apply {
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                setMargins(20, 0,20,0)
                topToTop = this@FavoritesView.id
                startToStart = this@FavoritesView.id
                endToEnd = this@FavoritesView.id
            }
        }
        tvShowsRecyclerView.apply {
            layoutParams = LayoutParams(MATCH_PARENT, 800).apply {
                topToBottom = tvShowsTitle.id
                startToStart = this@FavoritesView.id
                endToEnd = this@FavoritesView.id
            }
        }
        tvShowsRecyclerView.addItemDecoration(MyItemDecoration(10,10,10,0))
        moviesTitle.apply {
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                setMargins(20, 20,20,20)
                topToBottom = tvShowsRecyclerView.id
                startToStart = this@FavoritesView.id
                endToEnd = this@FavoritesView.id
            }
        }
        moviesRecyclerView.apply {
            layoutParams = LayoutParams(MATCH_PARENT, 800).apply {
                topToBottom = moviesTitle.id
                startToStart = this@FavoritesView.id
                endToEnd = this@FavoritesView.id
            }
        }
        moviesRecyclerView.addItemDecoration(MyItemDecoration(20,20,10,0))

        addView(tvShowsTitle)
        addView(tvShowsRecyclerView)
        addView(moviesTitle)
        addView(moviesRecyclerView)
    }
}