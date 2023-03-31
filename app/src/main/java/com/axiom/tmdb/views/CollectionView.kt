package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.color.Theme.color

class CollectionView(context: Context):ConstraintLayout(context){
    var title= TextView(context).applyId().bold().color(Color.BLACK).size(14)
    var name=TextView(context).applyId().bold().color(Color.BLACK)
    var unknown=TextView(context).applyId()
    var image=ImageView(context).applyId()

    init{
        applyId()
        layoutParams=LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        title.layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToTop=this@CollectionView.id
            startToStart=this@CollectionView.id
            endToEnd=this@CollectionView.id
        }
        addView(title)

        name.layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToBottom=title.id
            startToStart=this@CollectionView.id
            endToEnd=this@CollectionView.id
        }


        image.layoutParams= LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToBottom=name.id
            startToStart=this@CollectionView.id
        }

        unknown.layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToBottom=title.id
            startToStart=this@CollectionView.id
            endToEnd=this@CollectionView.id
        }
    }
}