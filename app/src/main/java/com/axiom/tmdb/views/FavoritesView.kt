package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color

class FavoritesView(context: Context):ConstraintLayout(context){
    var tvShowsTitle=TextView(context).text("Favorite TV Shows").color(Color.BLACK).size(20)
    var tvShowsRecyclerView=RecyclerView(context)
    var moviesTitle=TextView(context).text("Favorite Movies").color(Color.BLACK).size(20)
    var moviesRecyclerView=RecyclerView(context)
    init {
        id= View.generateViewId()
        tvShowsTitle.apply {
            id= View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToTop = this@FavoritesView.id
                startToStart = this@FavoritesView.id
                endToEnd = this@FavoritesView.id
            }
        }
        tvShowsRecyclerView.apply {
            id= View.generateViewId()
           // setBackgroundColor(Color.RED)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, 800).apply {
                topToBottom = tvShowsTitle.id
                startToStart = this@FavoritesView.id
                endToEnd = this@FavoritesView.id
            }
        }
        moviesTitle.apply {
            id= View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                setMargins(0, 20,0,0)
                topToBottom = tvShowsRecyclerView.id
                startToStart = this@FavoritesView.id
                endToEnd = this@FavoritesView.id
            }
        }
        moviesRecyclerView.apply {
            id= View.generateViewId()
           // setBackgroundColor(Color.BLUE)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, 800).apply {
                topToBottom = moviesTitle.id
                startToStart = this@FavoritesView.id
                endToEnd = this@FavoritesView.id
               // bottomToBottom = this@FavoritesView.id
            }
        }


        addView(tvShowsTitle)
        addView(tvShowsRecyclerView)
        addView(moviesTitle)
        addView(moviesRecyclerView)
    }
}