package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color

class TVShowView(context: Context) : ScrollView(context) {
    var tvShowViews:MutableList<View> = mutableListOf()
    var linearLayout = LinearLayout(context).applyId()

    init{
        tvShowViews.add(TextView(context).applyId().color(Color.BLACK).bold().size(22))
        tvShowViews.add(ImageView(context).applyId())
        tvShowViews.add(SpecialView(context))

        for(i in 3 .. 10){
            tvShowViews.add(TitleDescriptionView(context).vertical())
        }
        tvShowViews.add(TVShowLastEpisodeView(context))

        for(i in 12 .. 18){
            tvShowViews.add(TitleDescriptionView(context).vertical())
        }
        tvShowViews.add(ImageView(context).applyId())
        tvShowViews.add(SpecialView(context))

        for(i in 21 .. 27){
            tvShowViews.add(TitleDescriptionView(context).vertical())
        }

        tvShowViews.add(Button(context).applyId().text("Reviews").apply {
            layoutParams=LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        })
        linearLayout.apply {
            orientation=LinearLayout.VERTICAL
            layoutParams=LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                setMargins(10,0,10,dp(20))
            }
        }
        for(x in tvShowViews){
            linearLayout.addView(x,linearLayout.layoutParams)
        }

        addView(linearLayout)
    }
}