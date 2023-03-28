package com.axiom.tmdb.views


import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color
import com.facebook.shimmer.ShimmerFrameLayout

class TVShowsShimmer(context: Context) : ShimmerFrameLayout(context) {
    var tvShowViews:MutableList<View> = mutableListOf()
    var linearLayout = LinearLayout(context).applyId()
    var scrollView = ScrollView(context).applyId()
    init{
        applyId()
        layoutParams= LayoutParams(MATCH_PARENT, MATCH_PARENT)
        scrollView.layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        linearLayout.layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        tvShowViews.add(TextView(context).applyId().color(Color.BLACK).bold().size(22).apply {
            setBackgroundColor(Color.GRAY)
        })
        tvShowViews.add(ConstraintLayout(context).applyId().apply {
            setBackgroundColor(Color.GRAY)
            layoutParams=LinearLayout.LayoutParams(400,400).apply {
                minHeight=dp(250)

            }

        })
        tvShowViews.add(SpecialView(context).apply {
            setBackgroundColor(Color.GRAY)
        })

        for(i in 3 .. 10){
            tvShowViews.add(TitleDescriptionView(context).vertical().apply {
                setBackgroundColor(Color.GRAY)
            })
        }
        tvShowViews.add(TVShowLastEpisodeView(context).apply {
            setBackgroundColor(Color.GRAY)
        })

        for(i in 12 .. 18){
            tvShowViews.add(TitleDescriptionView(context).vertical().apply {
                setBackgroundColor(Color.GRAY)
            })
        }
        tvShowViews.add(ImageView(context).applyId().apply{
            setBackgroundColor(Color.GRAY)
            layoutParams=LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                minimumHeight=dp(250)
            }
        })
        tvShowViews.add(SpecialView(context))

        for(i in 21 .. 27){
            tvShowViews.add(TitleDescriptionView(context).vertical().apply {
                setBackgroundColor(Color.GRAY)
            })
        }

        tvShowViews.add(Button(context).applyId().apply {
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
        scrollView.addView(linearLayout)
        addView(scrollView)

    }
}