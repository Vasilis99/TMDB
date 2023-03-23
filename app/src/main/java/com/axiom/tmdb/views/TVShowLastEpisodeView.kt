package com.axiom.tmdb.views

import android.graphics.Color
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.TextView


import android.content.Context
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color

class TVShowLastEpisodeView(context: Context) : ConstraintLayout(context) {
    var title=TextView(context).applyId().bold().color(Color.BLACK).text("Last episode to air").size(14)
    var scrollView=HorizontalScrollView(context).applyId()
    var smallConLayout = ConstraintLayout(context).applyId()
    var linLayout = LinearLayout(context).applyId()
    var overview = TitleDescriptionView(context).vertical()
    var image = ImageView(context).applyId()
    var unknown = TextView(context).color(Color.BLACK).applyId().text("Unknown")
    var lastEpViews: MutableList<View> = mutableListOf()

    init {
        id = generateViewId()
        layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        title.layoutParams=ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToTop=this@TVShowLastEpisodeView.id
            startToStart=this@TVShowLastEpisodeView.id
            endToEnd=this@TVShowLastEpisodeView.id
        }
        addView(title)
        scrollView.layoutParams=ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToBottom=title.id
            bottomToBottom=this@TVShowLastEpisodeView.id
            startToStart=this@TVShowLastEpisodeView.id
            endToEnd=this@TVShowLastEpisodeView.id
        }
        scrollView.addView(smallConLayout)
        smallConLayout.layoutParams=FrameLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)

        linLayout.orientation = LinearLayout.VERTICAL
        linLayout.layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop = smallConLayout.id
            startToStart = smallConLayout.id
        }
        smallConLayout.addView(linLayout)
        for (i in 0..6) {
            var titleDescription= TitleDescriptionView(context).horizontal()
            titleDescription.title.size(12)
            lastEpViews.add(titleDescription)
        }

        for (x in lastEpViews) {
            linLayout.addView(x)
        }
        overview.title.size(12)
        overview.layoutParams = ConstraintLayout.LayoutParams(800, WRAP_CONTENT).apply {
            topToTop = smallConLayout.id
            startToEnd = linLayout.id
        }
        smallConLayout.addView(overview)

        image.layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop = smallConLayout.id
            startToEnd = overview.id
        }
        smallConLayout.addView(image)
        unknown.layoutParams=ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToBottom=title.id
            bottomToBottom=this@TVShowLastEpisodeView.id
            startToStart=this@TVShowLastEpisodeView.id
            endToEnd=this@TVShowLastEpisodeView.id
        }
    }

}