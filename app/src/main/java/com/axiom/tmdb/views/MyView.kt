package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MyView(context: Context) : LinearLayout(context) {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2

    init {
        orientation= VERTICAL
        tabLayout = TabLayout(context)
        tabLayout.id = View.generateViewId()


//        tabLayout.addTab(tabLayout.newTab().setText("Tabsd 1"))
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"))
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"))
//        myLayout.addView(tabLayout)

        viewPager = ViewPager2(context)
        viewPager.layoutParams=LinearLayout.LayoutParams(MATCH_PARENT,MATCH_PARENT)
        addView(tabLayout)
        addView(viewPager)



    }

}