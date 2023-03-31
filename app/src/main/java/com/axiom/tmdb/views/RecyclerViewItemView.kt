package com.axiom.tmdb.views


import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Image.image
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.color.Theme.color
import com.axiomc.tmdb.R


class RecyclerViewItemView(context: Context) : ConstraintLayout(context) {
    var image= ImageView(context).applyId()
    var conLayBig=ConstraintLayout(context).applyId()
    var conLayFirst=ConstraintLayout(context).applyId()
    var pos=TextView(context).applyId()
    var title=TextView(context).applyId().color(Color.BLACK).bold().size(14)
    var conLaySecond=ConstraintLayout(context).applyId()
    var star=ImageView(context).applyId().image(R.drawable.star_rate)
    var rating=TextView(context).applyId()
    var overview=TextView(context).applyId()
    var voteCount=TextView(context).applyId()
    var favorite=CheckBox(context).applyId().apply{setButtonDrawable(R.drawable.selector_favorite)}


    init{
        id= View.generateViewId()
        layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        image.layoutParams=LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop=this@RecyclerViewItemView.id
            bottomToBottom=this@RecyclerViewItemView.id
            startToStart=this@RecyclerViewItemView.id
        }
        addView(image)
        conLayBig.layoutParams= LayoutParams(0, WRAP_CONTENT).apply {
            topToTop=this@RecyclerViewItemView.id
            bottomToBottom=this@RecyclerViewItemView.id
            startToEnd=image.id
            endToEnd=this@RecyclerViewItemView.id
            setMargins(20,0,20,0)
        }
        addView(conLayBig)
        conLayFirst.layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToTop=conLayBig.id
            startToStart=conLayBig.id
            endToEnd=conLayBig.id
            setMargins(0,0,dp(24),0)
        }

        conLayBig.addView(conLayFirst)
        pos.layoutParams= LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop=conLayFirst.id
            bottomToBottom=conLayFirst.id
            startToStart=conLayFirst.id
        }
        conLayFirst.addView(pos)
        title.layoutParams= LayoutParams(0, WRAP_CONTENT).apply {
            topToTop=conLayFirst.id
            bottomToBottom=conLayFirst.id
            startToEnd=pos.id
            endToEnd=conLayFirst.id
        }
        conLayFirst.addView(title)


        favorite.layoutParams= LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop=this@RecyclerViewItemView.id
            endToEnd=this@RecyclerViewItemView.id
            setMargins(0,20,20,0)
        }
        addView(favorite)
        conLaySecond.layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToBottom=conLayFirst.id
            startToStart=conLayBig.id
        }
        conLayBig.addView(conLaySecond)
        star.layoutParams= LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop=conLaySecond.id
            bottomToBottom=conLaySecond.id
            startToStart=conLaySecond.id
        }
        conLaySecond.addView(star)

        rating.layoutParams= LayoutParams(70, WRAP_CONTENT).apply {
            topToTop=conLaySecond.id
            bottomToBottom=conLaySecond.id
            startToEnd=star.id
        }
        conLaySecond.addView(rating)

        voteCount.layoutParams= LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop=conLaySecond.id
            bottomToBottom=conLaySecond.id
            startToEnd=rating.id
            marginStart=20

        }
        conLaySecond.addView(voteCount)

        overview.layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            topToBottom=conLaySecond.id
            startToStart=conLayBig.id
            bottomToBottom=conLayBig.id
        }
        conLayBig.addView(overview)


    }
}