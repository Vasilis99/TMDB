package com.axiom.tmdb

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop

class TVShowView(context: Context) : ScrollView(context) {
    var constLayout = ConstraintLayout(context)
    var name = TextView(context)
    var backdrop = TextView(context)
    var backdropImage = ImageView(context)
    var createdBy = ConstraintLayout(context)
    var episodeRunTime = TextView(context)
    var firstAirDate = TextView(context)
    var genres = TextView(context)
    var homepage = TextView(context)
    var tvShowID = TextView(context)
    var inProduction = TextView(context)
    var languages = TextView(context)
    var lastAirDate = TextView(context)
    var lastEpisodeToAirTitle=TextView(context)
    var lastEpisodeToAir=ConstraintLayout(context)
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
    var networks=ConstraintLayout(context)
    var numberOfEpisodes = TextView(context)
    var numberOfSeasons = TextView(context)
    var originCountry = TextView(context)
    var originalLanguage = TextView(context)
    var originalName = TextView(context)
    var overview = TextView(context)
    var popularity = TextView(context)
    var poster = ImageView(context)
    var productionCompanies = ConstraintLayout(context)
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
        constLayout.apply {
            layoutParams = LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                id = View.generateViewId()
            }
        }

        name.apply {
            setTextColor(Color.BLACK)
            textSize = 20F
            typeface = Typeface.DEFAULT_BOLD
            name.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToTop = constLayout.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(name)

        backdrop.apply {
            setTextColor(Color.BLACK)
            typeface = Typeface.DEFAULT_BOLD
            backdrop.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = name.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
    constLayout.addView(backdrop)
        backdropImage.apply {
            backdropImage.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = backdrop.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(backdropImage)

        createdBy.apply {
            createdBy.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = backdropImage.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(createdBy)

        genres.apply {
            setTextColor(Color.BLACK)
            genres.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = createdBy.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(genres)

        homepage.apply {
            setTextColor(Color.BLACK)
            homepage.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = genres.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(homepage)

        tvShowID.apply {
            setTextColor(Color.BLACK)
            tvShowID.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = homepage.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(tvShowID)

        inProduction.apply {
            setTextColor(Color.BLACK)
            inProduction.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = tvShowID.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(inProduction)


        languages.apply {
            setTextColor(Color.BLACK)
            languages.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = inProduction.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(languages)

        lastEpisodeToAir.apply {
            lastEpisodeToAir.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = languages.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(lastEpisodeToAir)

        nextEpisodeToAir.apply {
            setTextColor(Color.BLACK)
            nextEpisodeToAir.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = lastEpisodeToAir.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(nextEpisodeToAir)

        networks.apply {
            networks.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = nextEpisodeToAir.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(networks)

        numberOfEpisodes.apply {
            setTextColor(Color.BLACK)
            numberOfEpisodes.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = networks.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(numberOfEpisodes)

        numberOfSeasons.apply {
            setTextColor(Color.BLACK)
            numberOfSeasons.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = numberOfEpisodes.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(numberOfSeasons)

        originCountry.apply {
            setTextColor(Color.BLACK)
            originCountry.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = numberOfSeasons.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(originCountry)

        originalLanguage.apply {
            setTextColor(Color.BLACK)
            originalLanguage.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = originCountry.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(originalLanguage)

        originalName.apply {
            setTextColor(Color.BLACK)
            originalName.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = originalLanguage.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(originalName)

        overview.apply {
            setTextColor(Color.BLACK)
            overview.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = originalName.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(overview)

        popularity.apply {
            setTextColor(Color.BLACK)
            popularity.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = overview.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(popularity)

        poster.apply {
            popularity.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = popularity.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(poster)

        productionCompanies.apply {
            productionCompanies.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = poster.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(productionCompanies)

        productionCountries.apply {
            setTextColor(Color.BLACK)
            productionCountries.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = productionCompanies.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(productionCountries)

        seasons.apply {
            seasons.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = productionCountries.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(seasons)

        spokenLanguages.apply {
            setTextColor(Color.BLACK)
            spokenLanguages.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = seasons.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(spokenLanguages)

        status.apply {
            setTextColor(Color.BLACK)
            status.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = spokenLanguages.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(status)

        tagline.apply {
            setTextColor(Color.BLACK)
            tagline.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = status.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(tagline)

        type.apply {
            setTextColor(Color.BLACK)
            type.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = tagline.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(type)

        voteAverage.apply {
            setTextColor(Color.BLACK)
            voteAverage.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = type.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(voteAverage)

        voteCount.apply {
            setTextColor(Color.BLACK)
            voteCount.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT).apply {
                topToBottom = voteAverage.id
                topMargin=16
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(voteCount)
        addView(constLayout)

    }


}