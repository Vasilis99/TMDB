package com.axiom.tmdb

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.design.color.Theme.color

class TVShowProductionCompanyViewItem(context:Context): ConstraintLayout(context) {
    var name=TextView(context).applyId().color(Color.BLACK)
    var image=ImageView(context).applyId()
    init{
        layoutParams= LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        id= generateViewId()
        name.layoutParams=ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                topToTop=this@TVShowProductionCompanyViewItem.id
                startToStart=this@TVShowProductionCompanyViewItem.id
                endToEnd=this@TVShowProductionCompanyViewItem.id
            }
        addView(name)
        image.layoutParams=ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                topToBottom=name.id
                startToStart=this@TVShowProductionCompanyViewItem.id
                endToEnd=this@TVShowProductionCompanyViewItem.id
            }
        addView(image)
    }

}