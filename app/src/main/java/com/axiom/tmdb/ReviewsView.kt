package com.axiom.tmdb

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class ReviewsView(context: Context): ScrollView(context)  {
    class ReviewView(cont:Context):LinearLayout(cont){
        var author=TextView(cont)
        var content=TextView(cont)
        var createdAt=TextView(cont)
        var updatedAt=TextView(cont)
        var url=TextView(context)
        init{
            orientation=LinearLayout.VERTICAL
            id= View.generateViewId()
            layoutParams=ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            author.apply{
                setTextColor(Color.BLACK)
            }
            content.apply{
                setTextColor(Color.BLACK)
            }
            createdAt.apply{
                setTextColor(Color.BLACK)
            }
            updatedAt.apply{
                setTextColor(Color.BLACK)
            }
            url.apply{
                setTextColor(Color.BLACK)
            }
            addView(author)
            addView(content)
            addView(createdAt)
            addView(updatedAt)
            addView(url)
        }
    }
    var linLayout=LinearLayout(context)
    var title=TextView(context)
    init{
        addView(linLayout)
        id= View.generateViewId()
        layoutParams=LayoutParams(MATCH_PARENT,MATCH_PARENT)
        linLayout.apply {
            orientation=LinearLayout.VERTICAL
            id=View.generateViewId()
            layoutParams= LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        }
        linLayout.addView(title)
        title.apply{
            setTextColor(Color.BLACK)
            typeface= Typeface.DEFAULT_BOLD
            textSize= 20F
            layoutParams=LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        }

    }
}