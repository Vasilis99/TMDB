package com.axiom.tmdb

import android.annotation.TargetApi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.preference.PreferenceManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab
import com.google.android.material.tabs.TabLayoutMediator



class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout:TabLayout
    private lateinit var viewPager:ViewPager2
    lateinit var myLayout:FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myLayout=  FrameLayout(this)
        myLayout.id= View.generateViewId()
        setContentView(myLayout)
        var myFragment=MyFragment()
        supportFragmentManager.
        beginTransaction().add(myLayout.id, myFragment)
              // .apply { if (backStack) addToBackStack(null) }
                .commit()



//        tabLayout= TabLayout(this)
//        tabLayout.id=View.generateViewId()
//
////        tabLayout.addTab(tabLayout.newTab().setText("Tabsd 1"))
////        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"))
////        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"))
////        myLayout.addView(tabLayout)
//
//        viewPager=ViewPager2(this)
//        myLayout.addView(tabLayout)
//        myLayout.addView(viewPager)
//
//        var vpAdapter = VPAdapter(this)
//        viewPager.adapter=vpAdapter
//
//        TabLayoutMediator(
//            tabLayout,
//            viewPager
//        ) { tab, position -> when (position){
//          0-> tab.text = "Top Rated Shows"
//          1-> tab.text = "Top Rated Movies"
//            2-> tab.text = "Search Movies-TV Shows"
//        }}.attach()




    }
}