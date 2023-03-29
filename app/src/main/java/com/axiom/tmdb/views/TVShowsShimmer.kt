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
import com.axiomc.core.dslanguage.constraint.Helpers.add
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color
import com.facebook.shimmer.ShimmerFrameLayout

class TVShowsShimmer(context: Context) : ShimmerFrameLayout(context) {
    var tvShowViews: MutableList<View> = mutableListOf()
    var linearLayout = LinearLayout(context).applyId()
    var scrollView = ScrollView(context).applyId()


    private fun myShimmer(): ConstraintLayout {
        var conLay = ConstraintLayout(context).applyId()
        var title = TextView(context).applyId().size(14)
        var desc = TextView(context).applyId()
        title.setBackgroundColor(Color.GRAY)
        title.layoutParams = ConstraintLayout.LayoutParams(dp(100), WRAP_CONTENT).apply {
            topToTop = conLay.id
            startToStart = conLay.id

        }
        desc.setBackgroundColor(Color.GRAY)
        desc.layoutParams = ConstraintLayout.LayoutParams(dp(100), WRAP_CONTENT).apply {
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
            layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
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
                layoutParams = ConstraintLayout.LayoutParams(dp(200), dp(140)).apply {
                    topToBottom = name.id
                    startToStart = creator.id
                    endToEnd = creator.id
                    minHeight=dp(100)
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
        scrollView.layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        linearLayout.layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        tvShowViews.add(TextView(context).applyId().color(Color.BLACK).bold().size(22).apply {
            setBackgroundColor(Color.GRAY)
            layoutParams = LinearLayout.LayoutParams(dp(100), WRAP_CONTENT)
        })
        tvShowViews.add(ConstraintLayout(context).applyId().apply {
            setBackgroundColor(Color.GRAY)
            layoutParams = LinearLayout.LayoutParams(400, 400).apply {
                minHeight = dp(250)

            }

        })
        tvShowViews.add(creators())

        for (i in 3..10) {
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
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                minimumHeight = dp(250)
            }
        })
        tvShowViews.add(SpecialView(context))

        for (i in 21..27) {
            tvShowViews.add(myShimmer())
        }

        tvShowViews.add(Button(context).applyId().apply {
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        })
        linearLayout.apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                setMargins(10, 0, 10, dp(20))
            }
        }
        for (x in tvShowViews) {
            linearLayout.addView(x, linearLayout.layoutParams)
        }
        scrollView.addView(linearLayout)
        addView(scrollView)

    }
}