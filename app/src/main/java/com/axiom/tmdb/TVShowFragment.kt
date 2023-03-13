package com.axiom.tmdb

import android.graphics.Color
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

class TVShowFragment : Fragment() {

    private val vm by viewModels<MovieViewModel>()
    private var tvShowID: Int = 0
    private lateinit var tvShowDetails: TMDB.TVShowDetails

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

        } else if (bundle == null) {
            Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show();
        }
        println("Fragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("On destroy")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = TVShowView(inflater.context)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenResumed {
            val myApi = TVShowFragment.RetrofitHelper.getInstance().create(MyApi::class.java)
            var response = myApi.getTVShowDetails(tvShowID)
            tvShowDetails = response.body()!!
            var tvShowView = (view as TVShowView)
            tvShowView.apply {
                name.text = tvShowDetails.name
                backdrop.text = "Backdrop image"
                var url1 =
                    "https://image.tmdb.org/t/p/original" + tvShowDetails.backdrop_path
                backdropImage.load(url1)
                var profileImage = ImageView(context)

                for ((i, x) in tvShowDetails.created_by.withIndex()) {
                    var name = TextView(context)
                    name.apply {
                        name.id = View.generateViewId()
                        text = Html.fromHtml("<p><b>Name</b><br>" + x.name + "</p>", 1)

                    }

                    createdBy.addView(name)

                    var creatorID = TextView(context)
                    creatorID.apply {
                        creatorID.id = View.generateViewId()
                        text = Html.fromHtml("<p><b>ID</b><br>" + x.id + "</p>", 1)
                    }
                    createdBy.addView(creatorID)

                    var creatorCreditID = TextView(context)
                    creatorCreditID.apply {
                        creatorCreditID.id = View.generateViewId()
                        text = Html.fromHtml("<p><b>ID</b><br>" + x.credit_id + "</p>", 1)
                    }
                    createdBy.addView(creatorCreditID)

                    var gender = TextView(context)
                    gender.apply {
                        gender.id = View.generateViewId()
                        text = Html.fromHtml("<p><b>Gender</b><br>" + x.gender + "</p>", 1)
                    }
                    createdBy.addView(gender)

                    var profile = TextView(context)
                    profile.apply {
                        profile.id = View.generateViewId()
                        text = Html.fromHtml("<p><b>Profile</b></p>", 1)
                    }
                    createdBy.addView(profile)

                    profileImage = ImageView(context)
                    profileImage.apply {
                        profileImage.id = View.generateViewId()
                        profileImage.load("https://image.tmdb.org/t/p/original" + x.profile_path)
                    }

                    createdBy.addView(profileImage)
                }
                if (tvShowDetails.created_by.isEmpty()) {
                    var unknown = TextView(context)
                    unknown.apply {
                        name.id = View.generateViewId()
                        text = "Unknown"

                    }
                    createdBy.addView(unknown)
                }
                var epRunTime = ""
                for (x in tvShowDetails.episode_run_time) {
                    epRunTime += "$x<br>"
                }

                episodeRunTime.text =
                    Html.fromHtml("<p><b>Episode run time</b><br>$epRunTime</p>", 1)
                firstAirDate.text = Html.fromHtml(
                    "<p><b>First air date</b><br>${tvShowDetails.first_air_date}</p>",
                    1
                )
                var genres = ""
                for (x in tvShowDetails.genres) {
                    genres += "${x.name}<br>"
                }
                homepage.text =
                    Html.fromHtml("<p><b>Homepage</b><br>${tvShowDetails.homepage}</p>", 1)
                tvShowID.text =
                    Html.fromHtml("<p><b>Homepage</b><br>${tvShowDetails.id}</p>", 1)
                var inProd = if (tvShowDetails.inProduction) "Yes" else "No"
                inProduction.text = Html.fromHtml(
                    "<p><b>In production</b><br>${tvShowDetails.inProduction}</p>",
                    1
                )
                var lang = ""
                for (x in tvShowDetails.languages) {
                    lang += "${x}<br>"
                }
                languages.text = Html.fromHtml("<p><b>Languages</b><br>${lang}</p>", 1)
                lastEpisodeToAirTitle.text = "Last episode to Air"
                if (tvShowDetails.last_episode_to_air != null) {
                    airDate.text = Html.fromHtml(
                        "<p><b>Air Date</b><br>${tvShowDetails.last_episode_to_air.air_date}</p>",
                        1
                    )
                    episodeNumber.text = Html.fromHtml(
                        "<p><b>Episode number</b><br>${tvShowDetails.last_episode_to_air.episode_number}</p>",
                        1
                    )
                    episodeName.text = Html.fromHtml(
                        "<p><b>Episode name</b><br>${tvShowDetails.last_episode_to_air.name}</p>",
                        1
                    )
                    episodeOverview.text = Html.fromHtml(
                        "<p><b>Episode overview</b><br>${tvShowDetails.last_episode_to_air.overview}</p>",
                        1
                    )
                    productionCode.text = Html.fromHtml(
                        "<p><b>Production code</b><br>${tvShowDetails.last_episode_to_air.production_code}</p>",
                        1
                    )
                    seasonNumber.text = Html.fromHtml(
                        "<p><b>Season number</b><br>${tvShowDetails.last_episode_to_air.season_number}</p>",
                        1
                    )
                    still.load("https://image.tmdb.org/t/p/original" + tvShowDetails.last_episode_to_air.still_path)
                    lastEpisodeVoteAverage.text = Html.fromHtml(
                        "<p><b>Vote average</b><br>${tvShowDetails.last_episode_to_air.vote_average}</p>",
                        1
                    )
                    lastEpisodeVoteCount.text = Html.fromHtml(
                        "<p><b>Vote count</b><br>${tvShowDetails.last_episode_to_air.vote_count}</p>",
                        1
                    )
                }
                else{
                    airDate.text= "Unknown"
                }
                nextEpisodeToAir.text =
                    Html.fromHtml("<p><b>Next episode to air</b><br>${"Unknown"}</p>", 1)

                networksText.text = "Networks\n"

                for (x in tvShowDetails.networks) {
                    var networkName = TextView(context)
                    networkName.apply {
                        setTextColor((Color.BLACK))
                        text = Html.fromHtml("<p><b>Name</b><br>${x.name}</p>", 1)
                    }
                    var logo = ImageView(context)
                    still.load("https://image.tmdb.org/t/p/original" + x.logo_path)

                    var origCountry = TextView(context)

                }
                if (tvShowDetails.networks.isEmpty()) {
                    var temp = TextView(context)
                    temp.apply {
                        setTextColor(Color.BLACK)
                        text = "Unknown"
                    }
                }
                numberOfEpisodes.text = Html.fromHtml(
                    "<p><b>Number of episodes</b><br>${tvShowDetails.number_of_episodes}</p>",
                    1
                )
                numberOfSeasons.text = Html.fromHtml(
                    "<p><b>Number of seasons</b><br>${tvShowDetails.number_of_seasons}</p>",
                    1
                )
                var counties = ""
                for (x in tvShowDetails.origin_country) {
                    counties += "$x<br>"
                }
                originCountry.text =
                    Html.fromHtml("<p><b>Origin countries</b><br>${counties}</p>", 1)
                originalLanguage.text = Html.fromHtml(
                    "<p><b>Original language</b><br>${tvShowDetails.original_language}</p>",
                    1
                )
                originalName.text = Html.fromHtml(
                    "<p><b>Original name</b><br>${tvShowDetails.original_name}</p>",
                    1
                )
                overview.text =
                    Html.fromHtml("<p><b>Overview</b><br>${tvShowDetails.overview}</p>", 1)
                popularity.text = Html.fromHtml(
                    "<p><b>Popularity</b><br>${tvShowDetails.popularity}</p>",
                    1
                )

                poster.load("https://image.tmdb.org/t/p/original" + tvShowDetails.poster_path)

                productionCompaniesTitle.text = "Production Companies"

                for (x in tvShowDetails.production_companies) {
                    var name = TextView(context)
                    name.text = x.name
                    productionCompanies.addView(name)
                    var logoText = TextView(context)
                    logoText.setTextColor(Color.BLACK)
                    logoText.text = "Logo"
                    productionCompanies.addView(logoText)
                    var logo = ImageView(context)
                    logo.load("https://image.tmdb.org/t/p/original" + x.logo_path)
                    productionCompanies.addView(logo)
                    var originCountry = TextView(context)
                    originCountry.text = Html.fromHtml(
                        "<p><b>Origin country</b><br>${x.origin_country}</p>",
                        1
                    )

                }
                var prodCountries = ""
                for (x in tvShowDetails.production_countries) {
                    prodCountries += x.name + "<br>"
                }
                productionCountries.text = Html.fromHtml(
                    "<p><b>Production countries</b><br>${prodCountries}</p>",
                    1
                )
                var spokenLang = ""
                for (x in tvShowDetails.spoken_languages) {
                    spokenLanguages.text = x.english_name + "<br>"
                }
                spokenLanguages.text = Html.fromHtml(
                    "<p><b>Spoken languages</b><br>${spokenLang}</p>",
                    1
                )
                status.text = Html.fromHtml(
                    "<p><b>Status</b><br>${tvShowDetails.status}</p>",
                    1
                )
                tagline.text = Html.fromHtml(
                    "<p><b>Tagline</b><br>${tvShowDetails.tagline}</p>",
                    1
                )
                type.text = Html.fromHtml(
                    "<p><b>Type</b><br>${tvShowDetails.type}</p>",
                    1
                )
                voteAverage.text = Html.fromHtml(
                    "<p><b>Vote average</b><br>${tvShowDetails.vote_average}</p>",
                    1
                )
                voteCount.text = Html.fromHtml(
                    "<p><b>Vote count</b><br>${tvShowDetails.vote_count}</p>",
                    1
                )
                reviewsButton.setOnClickListener {
                    var tvShowReviewsFragment = TVShowReviewsFragment.newInstance(tvShowDetails.id,tvShowDetails.name)

                    (activity as? MainActivity)?.myLayout?.id?.let { it1 ->

                        var transaction =
                            activity?.supportFragmentManager?.beginTransaction()
                        transaction?.replace(it1, tvShowReviewsFragment)?.commit()
                        transaction?.addToBackStack(null)
                    }
                }
            }
//            call.enqueue(object : Callback<TMDB.TVShowDetails> {
//                @RequiresApi(Build.VERSION_CODES.N)
//                override fun onResponse(
//                    call: Call<TMDB.TVShowDetails>,
//                    response: Response<TMDB.TVShowDetails>
//                ) {
//                    if (!response.isSuccessful) {
//                        println("Response not successful. Code: " + response.code())
//                        return
//                    }
//                    println("Response successful" + response.body()?.id)
//
//                }
//
//                override fun onFailure(call: Call<TMDB.TVShowDetails>, t: Throwable) {
//                    println("on Failure $t")
//                }
//            })
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