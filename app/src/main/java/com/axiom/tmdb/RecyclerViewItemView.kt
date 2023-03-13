package com.axiom.tmdb


import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.axiomc.tmdb.R


class RecyclerViewItemView(context: Context) : ConstraintLayout(context) {

    var pos= TextView(context).apply {
        textSize= 20F
        setTextColor(Color.BLACK)
        typeface = Typeface.DEFAULT_BOLD
    }
    var text= TextView(context).apply {
        textSize= 20F
        setTextColor(Color.BLACK)
    }
    var favorite=CheckBox(context)
    var linearLayout=LinearLayout(context)

    init{
        id= View.generateViewId()
        layoutParams=LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        linearLayout.apply {
            layoutParams=ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                topToTop=this@RecyclerViewItemView.id
                bottomToBottom=this@RecyclerViewItemView.id
                startToStart=this@RecyclerViewItemView.id
            }
            orientation=LinearLayout.HORIZONTAL

        }

        linearLayout.addView(pos)
        linearLayout.addView(text)
        favorite.apply {
            layoutParams=ConstraintLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT).apply {
                topToTop=this@RecyclerViewItemView.id
                bottomToBottom=this@RecyclerViewItemView.id
                startToEnd=linearLayout.id
                endToEnd=this@RecyclerViewItemView.id
            }
        }
        addView(linearLayout)
        addView(favorite)
        favorite.setButtonDrawable(R.drawable.selector_favorite)

    }
}