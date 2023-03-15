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
import com.axiomc.core.dslanguage.constraint.Definition.define
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.constraint.Params.params0W
import com.axiomc.core.dslanguage.constraint.Params.paramsCW
import com.axiomc.core.dslanguage.constraint.Params.paramsWW
import com.axiomc.core.dslanguage.constraint.Units
import com.axiomc.tmdb.R


class RecyclerViewItemView(context: Context) : ConstraintLayout(context) {

    var pos= TextView(context).apply {
        textSize= 20F
        setTextColor(Color.BLACK)
        typeface = Typeface.DEFAULT_BOLD
    }.paramsWW(this)
    var text= TextView(context).apply {
        textSize= 20F
        setTextColor(Color.BLACK)
    }.params0W(this)
    var favorite=CheckBox(context).paramsWW(this)


    init{
        id= View.generateViewId()
        layoutParams=LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        define (Units.RP){
            pos.left(parent).top(parent).bot(parent)
            text.top(parent).left(pos.RIGHT).bot(parent).right(favorite.LEFT)
            favorite.top(parent).bot(parent).right(parent).alignRight()
//            favorite.apply {
//                layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
//                    topToTop = this@RecyclerViewItemView.id
//                    bottomToBottom = this@RecyclerViewItemView.id
//                    endToEnd = this@RecyclerViewItemView.id
//
//                }
//            }

        }
        favorite.setButtonDrawable(R.drawable.selector_favorite)
    }
}