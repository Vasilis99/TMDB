package com.axiom.tmdb.views.shimmer


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
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axiom.tmdb.MyItemDecoration
import com.axiom.tmdb.views.SpecialView
import com.axiom.tmdb.views.TVShowLastEpisodeView
import com.axiomc.core.components.generic.LazyConcat.bind
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Recycler.lazyAdd
import com.axiomc.core.dslanguage.design.Recycler.vLinear
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.color.Theme.color
import com.facebook.shimmer.ShimmerFrameLayout

class TVShowsShimmer(context: Context) : ShimmerFrameLayout(context) {
    var tvShowViews: MutableList<View> = mutableListOf()
    var recyclerView=RecyclerView(context).applyId()


    private fun myShimmer(): ConstraintLayout {
        var conLay = ConstraintLayout(context).applyId()
        var title = TextView(context).applyId().size(14)
        var desc = TextView(context).applyId()
        title.setBackgroundColor(Color.GRAY)
        title.layoutParams = ConstraintLayout.LayoutParams(dp(200), WRAP_CONTENT).apply {
            topToTop = conLay.id
            startToStart = conLay.id

        }
        desc.setBackgroundColor(Color.GRAY)
        desc.layoutParams = ConstraintLayout.LayoutParams(dp(200), WRAP_CONTENT).apply {
            topToBottom = title.id
            bottomToBottom = conLay.id
            startToStart = conLay.id
            setMargins(0, 10, 0, 0)
        }
        conLay.addView(title)
        conLay.addView(desc)
        return conLay
    }

    private fun creators(): ConstraintLayout {
        var conLay = ConstraintLayout(context).applyId().apply {
            layoutParams=LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        }
        var cTitle = TextView(context).applyId().size(14).apply {
            setBackgroundColor(Color.GRAY)
            layoutParams = ConstraintLayout.LayoutParams(dp(100), WRAP_CONTENT).apply {
                topToTop = conLay.id
                startToStart - conLay.id
            }
        }
        var linLayout = LinearLayout(context).applyId().apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToBottom = cTitle.id
                startToStart = conLay.id
                endToEnd = conLay.id
            }
        }

        for (i in 0..3) {
            var creator = ConstraintLayout(context).applyId().apply {
                layoutParams=LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                    setMargins(0,0,10,0)
                }
            }
            var name = TextView(context).applyId().apply {
                setBackgroundColor(Color.GRAY)
                layoutParams = ConstraintLayout.LayoutParams(dp(80), WRAP_CONTENT).apply {
                    topToTop = creator.id
                    startToStart = creator.id
                    endToEnd = creator.id
                }
            }
            var photo = ConstraintLayout(context).applyId().apply {
                setBackgroundColor(Color.BLACK)
                layoutParams = ConstraintLayout.LayoutParams(185, 300).apply {
                    topToBottom = name.id
                    startToStart = creator.id
                    endToEnd = creator.id
                    minHeight=dp(50)
                    setMargins(0, 10, 0, 0)
                }
            }
            creator.addView(name)
            creator.addView(photo)
            linLayout.addView(creator)
        }

        conLay.addView(cTitle)
        conLay.addView(linLayout)

        return conLay
    }

    init {
        applyId()
        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)

        tvShowViews.add(TextView(context).applyId().color(Color.BLACK).bold().size(22).apply {
            setBackgroundColor(Color.GRAY)
        })
        tvShowViews.add(ConstraintLayout(context).applyId().apply {
            setBackgroundColor(Color.GRAY)
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)

        })
        //tvShowViews.add(creators())

        for (i in 2..10) {
            tvShowViews.add(myShimmer())
        }
        tvShowViews.add(TVShowLastEpisodeView(context).apply {
            setBackgroundColor(Color.GRAY)
        })

        for (i in 12..18) {
            tvShowViews.add(myShimmer())
        }
        tvShowViews.add(ImageView(context).applyId().apply {
            setBackgroundColor(Color.GRAY)
        })
        tvShowViews.add(SpecialView(context))

        for (i in 21..27) {
            tvShowViews.add(myShimmer())
        }

        tvShowViews.add(Button(context).applyId().apply {
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        })

        recyclerView.addItemDecoration(MyItemDecoration(10,10,0,dp(20)))
        recyclerView.layoutManager=object : LinearLayoutManager(context) { override fun canScrollVertically() = false}
        recyclerView.lazyAdd {
            for (i in 0..28) {
                when (i) {
                    0 -> {
                        add(tvShowViews[i].bind {
                            width = 800
                        })
                    }
                    1 -> {
                        add(tvShowViews[i].bind{
                            height=596
                        })
                    }
                    19 -> {
                        add(tvShowViews[i].bind {
                            height=1500
                        })
                    }
                    else -> {
                        add(tvShowViews[i])
                    }
                }
            }
        }
        addView(recyclerView)

    }
}