package com.axiom.tmdb

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.axiomc.core.deprecated.model.Data.textColor

class TVShowView(context: Context) : ScrollView(context) {
    var linearLayout = LinearLayout(context)
    var name = TextView(context)
    var backdrop = TextView(context)
    var backdropImage = ImageView(context)
    var createdByTitle=TextView(context)
    var createdBy=LinearLayout(context)
    var episodeRunTime = TextView(context)
    var firstAirDate = TextView(context)
    var genres = TextView(context)
    var homepage = TextView(context)
    var tvShowID = TextView(context)
    var inProduction = TextView(context)
    var languages = TextView(context)
    var lastAirDate = TextView(context)
    var lastEpisodeToAirTitle=TextView(context)
    var lastEpisodeToAir=LinearLayout(context)
    var airDate=TextView(context)
    var episodeNumber= TextView(context)
    var episodeID= TextView(context)
    var episodeName= TextView(context)
    var episodeOverview= TextView(context)
    var productionCode= TextView(context)
    var seasonNumber= TextView(context)
    var still= ImageView(context)
    var lastEpisodeVoteAverage = TextView(context)
    var lastEpisodeVoteCount = TextView(context)
    var nextEpisodeToAir = TextView(context)
    var networksText=TextView(context)
    var networks=ConstraintLayout(context)
    var numberOfEpisodes = TextView(context)
    var numberOfSeasons = TextView(context)
    var originCountry = TextView(context)
    var originalLanguage = TextView(context)
    var originalName = TextView(context)
    var overview = TextView(context)
    var popularity = TextView(context)
    var poster = ImageView(context)
    var productionCompanies = LinearLayout(context)
    var productionCompaniesTitle=TextView(context)
    var productionCountries = TextView(context)
    var seasons= ConstraintLayout(context)
    var spokenLanguages = TextView(context)
    var status = TextView(context)
    var tagline = TextView(context)
    var type = TextView(context)
    var voteAverage = TextView(context)
    var voteCount = TextView(context)


    init{

        layoutParams = LayoutParams(MATCH_PARENT,MATCH_PARENT).apply {
            id = View.generateViewId()
        }
        linearLayout.apply {
            orientation=LinearLayout.VERTICAL
            layoutParams = LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                id = View.generateViewId()
            }
        }

        name.apply {
            setTextColor(Color.BLACK)
            textSize = 20F
            typeface = Typeface.DEFAULT_BOLD
            name.id = View.generateViewId()
         
        }
        linearLayout.addView(name)

        backdrop.apply {
            setTextColor(Color.BLACK)
            typeface = Typeface.DEFAULT_BOLD
            backdrop.id = View.generateViewId()

        }
    linearLayout.addView(backdrop)
        backdropImage.apply {
            backdropImage.id = View.generateViewId()
            }

        linearLayout.addView(backdropImage)

        createdByTitle.apply {
            setTextColor(Color.BLACK)
            createdByTitle.id=View.generateViewId()
            createdByTitle.text="Created by"
        }
        createdBy.addView(createdByTitle)
        createdBy.apply {
            orientation=LinearLayout.VERTICAL
            createdBy.id = View.generateViewId()
        }
        linearLayout.addView(createdBy)

        genres.apply {
            setTextColor(Color.BLACK)
            genres.id = View.generateViewId()

        }
        linearLayout.addView(genres)

        homepage.apply {
            setTextColor(Color.BLACK)
            homepage.id = View.generateViewId()

        }
        linearLayout.addView(homepage)

        tvShowID.apply {
            setTextColor(Color.BLACK)
            tvShowID.id = View.generateViewId()

        }
        linearLayout.addView(tvShowID)

        inProduction.apply {
            setTextColor(Color.BLACK)
            inProduction.id = View.generateViewId()

        }
        linearLayout.addView(inProduction)


        languages.apply {
            setTextColor(Color.BLACK)
            languages.id = View.generateViewId()

        }
        linearLayout.addView(languages)

        lastEpisodeToAir.apply {
            lastEpisodeToAir.id = View.generateViewId()

        }
        linearLayout.addView(lastEpisodeToAir)

        lastEpisodeToAirTitle.apply {
            lastEpisodeToAirTitle.id = View.generateViewId()

        }
        lastEpisodeToAir.addView(lastEpisodeToAirTitle)


        nextEpisodeToAir.apply {
            setTextColor(Color.BLACK)
            nextEpisodeToAir.id = View.generateViewId()

        }
        linearLayout.addView(nextEpisodeToAir)

        networksText.apply {
            setTextColor(Color.BLACK)
            typeface= Typeface.DEFAULT_BOLD
            networksText.id = View.generateViewId()

        }
        linearLayout.addView(networksText)

        networks.apply {
            networks.id = View.generateViewId()

        }
        linearLayout.addView(networks)

        numberOfEpisodes.apply {
            setTextColor(Color.BLACK)
            numberOfEpisodes.id = View.generateViewId()

        }
        linearLayout.addView(numberOfEpisodes)

        numberOfSeasons.apply {
            setTextColor(Color.BLACK)

        }
        linearLayout.addView(numberOfSeasons)

        originCountry.apply {
            setTextColor(Color.BLACK)
            originCountry.id = View.generateViewId()

        }
        linearLayout.addView(originCountry)

        originalLanguage.apply {
            setTextColor(Color.BLACK)
            originalLanguage.id = View.generateViewId()

        }
        linearLayout.addView(originalLanguage)

        originalName.apply {
            setTextColor(Color.BLACK)
            originalName.id = View.generateViewId()

        }
        linearLayout.addView(originalName)

        overview.apply {
            setTextColor(Color.BLACK)
            overview.id = View.generateViewId()

        }
        linearLayout.addView(overview)

        popularity.apply {
            setTextColor(Color.BLACK)
            popularity.id = View.generateViewId()

        }
        linearLayout.addView(popularity)

        poster.apply {
            popularity.id = View.generateViewId()

        }
        linearLayout.addView(poster)

        productionCompanies.apply {
            productionCompanies.id = View.generateViewId()

        }
        productionCompaniesTitle.apply {
            setTextColor(Color.BLACK)
            productionCompanies.id = View.generateViewId()

        }
        productionCompanies.addView(productionCompaniesTitle)

        productionCountries.apply {
            setTextColor(Color.BLACK)
            productionCountries.id = View.generateViewId()

        }
        linearLayout.addView(productionCountries)

        seasons.apply {
            seasons.id = View.generateViewId()

        }
        linearLayout.addView(seasons)

        spokenLanguages.apply {
            setTextColor(Color.BLACK)
            spokenLanguages.id = View.generateViewId()

        }
        linearLayout.addView(spokenLanguages)

        status.apply {
            setTextColor(Color.BLACK)
            status.id = View.generateViewId()

        }
        linearLayout.addView(status)

        tagline.apply {
            setTextColor(Color.BLACK)
            tagline.id = View.generateViewId()

        }
        linearLayout.addView(tagline)

        type.apply {
            setTextColor(Color.BLACK)
            type.id = View.generateViewId()

        }
        linearLayout.addView(type)

        voteAverage.apply {
            setTextColor(Color.BLACK)
            voteAverage.id = View.generateViewId()

        }
        linearLayout.addView(voteAverage)

        voteCount.apply {
            setTextColor(Color.BLACK)
            voteCount.id = View.generateViewId()

        }
        linearLayout.addView(voteCount)
        addView(linearLayout)

    }


}