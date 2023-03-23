package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.design.color.Theme.color
import com.axiomc.tmdb.R

class FavoritesRecyclerViewItem(context: Context):ConstraintLayout(context) {
    var pos=TextView(context).applyId()
    var name=TextView(context).applyId().color(Color.BLACK)
    var image=ImageView(context).applyId()
    var delete=ImageView(context).applyId().apply {setImageResource(R.drawable.delete)}
    init{
        applyId()
        layoutParams= LayoutParams(MATCH_PARENT,WRAP_CONTENT)
        image.layoutParams= LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop=this@FavoritesRecyclerViewItem.id
            bottomToBottom=this@FavoritesRecyclerViewItem.id
            startToStart=this@FavoritesRecyclerViewItem.id
        }
        addView(image)
        pos.layoutParams= LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop=this@FavoritesRecyclerViewItem.id
            bottomToBottom=this@FavoritesRecyclerViewItem.id
            startToEnd=image.id
        }
        addView(pos)
        name.layoutParams= LayoutParams(0, WRAP_CONTENT).apply {
            topToTop=this@FavoritesRecyclerViewItem.id
            bottomToBottom=this@FavoritesRecyclerViewItem.id
            startToEnd=pos.id
            endToStart=delete.id
        }
        addView(name)
        delete.layoutParams= LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop=this@FavoritesRecyclerViewItem.id
            bottomToBottom=this@FavoritesRecyclerViewItem.id
            endToEnd=this@FavoritesRecyclerViewItem.id
        }
        addView(delete)

    }
}