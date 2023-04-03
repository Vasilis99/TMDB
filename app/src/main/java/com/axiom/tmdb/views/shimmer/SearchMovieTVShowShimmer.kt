package com.axiom.tmdb.views.shimmer

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.axiomc.core.components.text.AxiomEditText
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color
import com.facebook.shimmer.ShimmerFrameLayout

class SearchMovieTVShowShimmer(context: Context) : ShimmerFrameLayout(context) {
    var title = TextView(context).applyId().bold().color(Color.BLACK)
        .size(20).applyId()
    var tvShowInputBox = AxiomEditText(context).applyId()
    var tvShowButton = Button(context).applyId()
    var movieInputBox = AxiomEditText(context).applyId()
    var movieButton = Button(context).applyId()
    var conLay=ConstraintLayout(context).applyId()
    init {
        applyId()

        layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        title.layoutParams = ConstraintLayout.LayoutParams(400, WRAP_CONTENT).apply {
            topToTop = conLay.id
            startToStart = conLay.id
            endToEnd = conLay.id
            setMargins(20,0,20,0)
            setBackgroundColor(Color.GRAY)
        }

        conLay.addView(title)
        tvShowInputBox.layoutParams = ConstraintLayout.LayoutParams(400, WRAP_CONTENT).apply {
            topToBottom = title.id
            startToStart = conLay.id
            endToStart=tvShowButton.id
            setMargins(0,20,0,0)
            setBackgroundColor(Color.GRAY)
        }

        conLay.addView(tvShowInputBox)

        tvShowButton.layoutParams = ConstraintLayout.LayoutParams(400, WRAP_CONTENT).apply {
            topToBottom = title.id
            endToEnd = conLay.id
            startToEnd = tvShowInputBox.id
            setMargins(0,20,0,0)
            setBackgroundColor(Color.GRAY)
        }

        conLay.addView(tvShowButton)
        movieInputBox.layoutParams = ConstraintLayout.LayoutParams(400, WRAP_CONTENT).apply {
            topToBottom = tvShowInputBox.id
            startToStart = conLay.id
            endToStart=movieButton.id
            setBackgroundColor(Color.GRAY)
        }

        conLay.addView(movieInputBox)


        movieButton.layoutParams = ConstraintLayout.LayoutParams(400, WRAP_CONTENT).apply {
            topToBottom = tvShowButton.id
            startToEnd = movieInputBox.id
            endToEnd = conLay.id
        }
        conLay.addView(movieButton)
        addView(conLay)
    }
}