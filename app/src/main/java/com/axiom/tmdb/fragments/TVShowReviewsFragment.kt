package com.axiom.tmdb.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.axiom.tmdb.MyApi
import com.axiom.tmdb.RetrofitHelper
import com.axiom.tmdb.TMDB
import com.axiom.tmdb.views.ReviewsView

class TVShowReviewsFragment : Fragment() {
    var tvShowID = 0
    var tvShowTitle=""
    lateinit var tvShowReviews: TMDB.Reviews
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tvShowID = it.getInt("tvShowID")
            tvShowTitle= it.getString("tvShowTitle")!!

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = ReviewsView(inflater.context).apply {
        val myApi = RetrofitHelper.getInstance().create(MyApi::class.java)
        lifecycleScope.launchWhenResumed {
            val response = myApi.getTVShowReviews(tvShowID)

            tvShowReviews = response.body()!!
            title.text= "$tvShowTitle reviews"


            var reviewView: ReviewsView.ReviewView
            for((i,x) in tvShowReviews.results.withIndex()){
                reviewView= ReviewsView.ReviewView(context)
                reviewView.apply {
                    layoutParams= LinearLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT)
                }
                reviewView.author.text=Html.fromHtml("<p><b>Author</b><br>${x.author}</p>",1)
                reviewView.content.text=Html.fromHtml("<p><b>Content</b><br>${x.content}</p>",1)
                reviewView.createdAt.text=Html.fromHtml("<p><b>Created at</b><br>${x.created_at}</p>",1)
                reviewView.updatedAt.text=Html.fromHtml("<p><b>Updated at</b><br>${x.updated_at}</p>",1)
                reviewView.url.text=Html.fromHtml("<p><b>URLt</b><br>${x.url}</p>",1)

                linLayout.addView(reviewView)

            }
            if(tvShowReviews.results.isEmpty()){
                var noReviews=TextView(context)
                noReviews.apply{
                    setTextColor(Color.BLACK)
                    text="No reviews"
                }
                linLayout.addView(noReviews)
            }


        }
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int,title:String) =
            TVShowReviewsFragment().apply {
                arguments = Bundle().apply {
                    putInt("tvShowID", id)
                    putString("tvShowTitle",title)
                }
            }
    }
}