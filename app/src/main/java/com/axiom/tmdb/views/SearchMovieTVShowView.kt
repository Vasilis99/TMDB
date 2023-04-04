package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.axiom.tmdb.views.shimmer.SearchMovieTVShowShimmer
import com.axiomc.core.components.text.AxiomEditText
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.conversion.Space.rp
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color
import com.axiomc.core.dslanguage.utility.Layout.margins
import kotlinx.coroutines.awaitAll


class SearchMovieTVShowView(context: Context) : ConstraintLayout(context) {
    var title = TextView(context).applyId().bold().color(Color.BLACK).text("Search Movies-TV Shows")
        .size(20).applyId()
    var tvShowInputBox = AxiomEditText(context).applyId()
    var tvShowButton = Button(context).applyId().text("Search TV Show")
    var movieInputBox = AxiomEditText(context).applyId()
    var movieButton = Button(context).applyId().text("Search Movie")
    var shimmer=SearchMovieTVShowShimmer(context)
    init {
        id = generateViewId()
        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)

        title.layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToTop = this@SearchMovieTVShowView.id
            startToStart = this@SearchMovieTVShowView.id
            endToEnd = this@SearchMovieTVShowView.id
            setMargins(20,0,20,0)
        }

        addView(title)
        tvShowInputBox.layoutParams = LayoutParams(400, WRAP_CONTENT).apply {
            topToBottom = title.id
            startToStart = this@SearchMovieTVShowView.id
            endToStart=tvShowButton.id
            setMargins(0,20,0,0)
        }

        addView(tvShowInputBox)

        tvShowButton.layoutParams = LayoutParams(400, WRAP_CONTENT).apply {
            topToBottom = title.id
            endToEnd = this@SearchMovieTVShowView.id
            startToEnd = tvShowInputBox.id
            setMargins(0,20,0,0)
        }

        addView(tvShowButton)
        movieInputBox.layoutParams = LayoutParams(400, WRAP_CONTENT).apply {
            topToBottom = tvShowInputBox.id
            startToStart = this@SearchMovieTVShowView.id
            endToStart=movieButton.id
        }

        addView(movieInputBox)


        movieButton.layoutParams = LayoutParams(400, WRAP_CONTENT).apply {
            topToBottom = tvShowButton.id
            startToEnd = movieInputBox.id
            endToEnd = this@SearchMovieTVShowView.id
        }
        addView(movieButton)
        addView(shimmer)
        visibility= INVISIBLE
    }
}