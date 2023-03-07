package com.axiom.tmdb

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TVShowFragment: Fragment() {

    private val vm by viewModels<MovieViewModel>()
    private var tvShowID: Int = 0
    private lateinit var tvShowDetails:TMDB.TVShowDetails
    object RetrofitHelper {
        private const val baseUrl = "https://api.themoviedb.org/3/tv/"
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle != null && bundle.containsKey("tvShowID")) {
            tvShowID = bundle.getInt("tvShowID")
            println(tvShowID)
        } else if (bundle == null) {
            Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show();
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = TVShowView(inflater.context)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenResumed {
            val myApi = TVShowFragment.RetrofitHelper.getInstance().create(MyApi::class.java)
            var call = myApi.getTVShowDetails(tvShowID)
            println("Edo "+tvShowID)
            call.enqueue(object : Callback<TMDB.TVShowDetails> {
                @RequiresApi(Build.VERSION_CODES.N)
                override fun onResponse(call: Call<TMDB.TVShowDetails>, response: Response<TMDB.TVShowDetails>) {
                    if (!response.isSuccessful) {
                        println("Response not successful. Code: " + response.code())
                        return
                    }
                    println("Response successful"+response.body()?.id)
                    tvShowDetails=response.body()!!
                    var tvShowView=(view as TVShowView)
                    tvShowView.apply {
                        name.text=tvShowDetails.name
                        backdrop.text="Backdrop image"
                        var url1="https://image.tmdb.org/t/p/original"+tvShowDetails.backdrop_path
                        backdropImage.load(url1)
                        var profileImage=ImageView(context)
                        for((i,x) in tvShowDetails.created_by.withIndex()){
                            var name=TextView(context)
                            name.apply {
                                name.id = View.generateViewId()
                                layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                                    if(i==0){
                                        topToTop = createdBy.id
                                    }
                                    else{
                                        topToBottom=profileImage.id
                                    }

                                    topMargin=16
                                    startToStart = createdBy.id
                                    endToEnd = createdBy.id
                                }
                                text= Html.fromHtml("<p><b>Name</b><br>" + x.name+"</p>",1)

                            }

                            createdBy.addView(name)

                            var creatorID=TextView(context)
                            creatorID.apply {
                                creatorID.id = View.generateViewId()
                                layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                                    topToBottom = name.id
                                    topMargin=16
                                    startToStart = createdBy.id
                                    endToEnd = createdBy.id
                                }
                                text= Html.fromHtml("<p><b>ID</b><br>" + x.id+"</p>",1)
                            }
                            createdBy.addView(creatorID)

                            var creatorCreditID=TextView(context)
                            creatorCreditID.apply {
                                creatorCreditID.id = View.generateViewId()
                                layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                                    topToBottom = creatorID.id
                                    topMargin=16
                                    startToStart = createdBy.id
                                    endToEnd = createdBy.id
                                }
                                text= Html.fromHtml("<p><b>ID</b><br>" + x.credit_id+"</p>",1)
                            }
                            createdBy.addView(creatorCreditID)

                            var gender=TextView(context)
                            gender.apply {
                                gender.id = View.generateViewId()
                                layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                                    topToBottom = creatorCreditID.id
                                    topMargin=16
                                    startToStart = createdBy.id
                                    endToEnd = createdBy.id
                                }
                                text= Html.fromHtml("<p><b>Gender</b><br>" + x.gender+"</p>",1)
                            }
                            createdBy.addView(gender)

                            var profile=TextView(context)
                            profile.apply {
                                profile.id = View.generateViewId()
                                layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                                    topToBottom = gender.id
                                    topMargin=16
                                    startToStart = createdBy.id
                                    endToEnd = createdBy.id
                                }
                                text= Html.fromHtml("<p><b>Profile</b><br></p>",1)
                            }
                            createdBy.addView(profile)

                            profileImage=ImageView(context)
                            profileImage.apply {
                                profileImage.id = View.generateViewId()
                                layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                                    topToBottom = profile.id
                                    topMargin=16
                                    startToStart = createdBy.id
                                    endToEnd = createdBy.id
                                }
                                var url1="https://image.tmdb.org/t/p/original"+x.profile_path

                                profileImage.load(url1)
                            }

                            createdBy.addView(profileImage)

                        }
                    }
                }

                override fun onFailure(call: Call<TMDB.TVShowDetails>, t: Throwable) {
                    println("on Failure $t")
                }
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int) =
            TVShowFragment().apply {
                arguments = Bundle().apply {
                    putInt("tvShowID", id)
                }
            }
    }
}