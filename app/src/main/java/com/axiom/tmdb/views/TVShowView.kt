package com.axiom.tmdb.views

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.ImageView.ScaleType
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axiom.tmdb.MyItemDecoration
import com.axiom.tmdb.views.shimmer.TVShowsShimmer
import com.axiomc.core.components.generic.LazyConcat.bind
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Recycler.lazyAdd
import com.axiomc.core.dslanguage.design.Recycler.vLinear
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color


class TVShowView(context: Context) : ConstraintLayout(context) {
    var tvShowViews: MutableList<View> = mutableListOf()
    var linearLayout = LinearLayout(context).applyId()
    var recyclerView = RecyclerView(context).applyId()
    var tvShowsShimmer = TVShowsShimmer(context)

    init {
        applyId()
        this.setBackgroundColor(Color.WHITE)
        recyclerView.layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
        recyclerView.addItemDecoration(MyItemDecoration(10, 10, 0, dp(20)))

        tvShowViews.add(TextView(context).color(Color.BLACK).bold().size(22))


        tvShowViews.add(ImageView(context).applyId().apply {
            scaleType = ScaleType.FIT_CENTER
        })
        tvShowViews.add(SpecialView(context))


        for (i in 3..10) {
            tvShowViews.add(TitleDescriptionView(context).vertical())
        }
        tvShowViews.add(TVShowLastEpisodeView(context))

        for (i in 12..18) {
            tvShowViews.add(TitleDescriptionView(context).vertical())
        }
        tvShowViews.add(ImageView(context).applyId())
        tvShowViews.add(SpecialView(context))

        for (i in 21..27) {
            tvShowViews.add(TitleDescriptionView(context).vertical())
        }

        tvShowViews.add(Button(context).applyId().text("Reviews").apply {
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        })
        linearLayout.apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                setMargins(10, 0, 10, dp(20))
            }
        }
        var dpi=resources.displayMetrics.ydpi
        recyclerView.vLinear.lazyAdd {
            for (i in 0..28) {
                if(i==1){
                   add(tvShowViews[i].bind {
                       height= 596
                       width= MATCH_PARENT
                   })
                }
                else{
                    add(tvShowViews[i])
                }
            }
        }

        recyclerView.visibility = INVISIBLE
        addView(recyclerView)
        addView(tvShowsShimmer)
    }
}