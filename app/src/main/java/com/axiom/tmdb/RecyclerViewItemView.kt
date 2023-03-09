package com.axiom.tmdb

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class RecyclerViewItemView(context: Context) : LinearLayout(context) {

    var pos= TextView(context).apply {
        textSize= 20F
        setTextColor(Color.BLACK)
        typeface = Typeface.DEFAULT_BOLD
    }
    var text= TextView(context).apply {
        textSize= 20F
        setTextColor(Color.BLACK)
    }

    init{
        id= View.generateViewId()
        orientation=LinearLayout.HORIZONTAL
        addView(pos)
        addView(text)
    }
}