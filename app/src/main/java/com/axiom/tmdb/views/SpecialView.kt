package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.Text.text
import com.axiomc.core.dslanguage.design.color.Theme.color

class SpecialView(context: Context):ConstraintLayout(context) {
    var title=TextView(context).applyId().color(Color.BLACK).bold().size(14)
    var unknown=TextView(context).applyId().text("Unknown")
    var recyclerView=RecyclerView(context).applyId()
    init{
        applyId()
        layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        title.apply {
            layoutParams=ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToTop=this@SpecialView.id
                startToStart=this@SpecialView.id
                endToEnd=this@SpecialView.id
            }
        }
        unknown.apply {
            layoutParams=ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToBottom=title.id
                startToStart=this@SpecialView.id
                endToEnd=this@SpecialView.id
            }
        }
        recyclerView.apply {
            layoutParams=ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToBottom=title.id
                startToStart=this@SpecialView.id
                endToEnd=this@SpecialView.id
            }
        }
        addView(title)
//        addView(unknown)
//        addView(recyclerView)
    }
}