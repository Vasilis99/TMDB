package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.axiom.tmdb.MyItemDecoration
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color

class TopRatedTVShowsView(context: Context) : ConstraintLayout(context) {
    private val title = TextView(context).applyId().bold().color(Color.BLACK).text("Top rated TV Shows").size(20)

    public val tvShowsRecyclerView = RecyclerView(context)



    init {

        applyId()
        layoutParams= LayoutParams(MATCH_PARENT, MATCH_PARENT)
        title.layoutParams=ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToTop=this@TopRatedTVShowsView.id
            startToStart=this@TopRatedTVShowsView.id
            endToEnd=this@TopRatedTVShowsView.id
        }
        addView(title)
        tvShowsRecyclerView.layoutParams =
            ConstraintLayout.LayoutParams(MATCH_PARENT, 0).apply {
                topToBottom=title.id
                startToStart=this@TopRatedTVShowsView.id
                endToEnd=this@TopRatedTVShowsView.id
                bottomToBottom=this@TopRatedTVShowsView.id
                setMargins(0,dp(20),0,0)
            }
        tvShowsRecyclerView.addItemDecoration(MyItemDecoration(20))

        addView(tvShowsRecyclerView)

    }

}