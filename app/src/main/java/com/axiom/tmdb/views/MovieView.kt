package com.axiom.tmdb.views

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class MovieView(context: Context) : ScrollView(context) {
    var constLayout = ConstraintLayout(context)
    var title = TextView(context)
    var adult = TextView(context)
    var backdrop = TextView(context)
    var backdropImage = ImageView(context)
    var belongsToCollection = LinearLayout(context)
    var belongsToCollectionID = TextView(context)
    var belongsToCollectionName = TextView(context)
    var belongsToCollectionPoster = ImageView(context)
    var belongsToCollectionBackdrop = ImageView(context)
    var budget = TextView(context)
    var genres = TextView(context)
    var homepage = TextView(context)
    var movieID = TextView(context)
    var imdbID = TextView(context)
    var originalLanguage = TextView(context)
    var originalTitle = TextView(context)
    var overview = TextView(context)
    var popularity = TextView(context)
    var posterText = TextView(context)
    var posterImage = ImageView(context)
    var productionCompanies = LinearLayout(context)
    var productionCountries = TextView(context)
    var releaseDate = TextView(context)
    var revenue = TextView(context)
    var runtime = TextView(context)
    var spokenLanguages = TextView(context)
    var status = TextView(context)
    var tagline = TextView(context)
    var video = TextView(context)
    var voteAverage = TextView(context)
    var voteCount = TextView(context)
    var reviewsButton=Button(context)

    init {
        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT).apply {
            id = View.generateViewId()
        }
        constLayout.apply {
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
            }
        }
        title.apply {
            setTextColor(Color.BLACK)
            textSize = 20F
            typeface = Typeface.DEFAULT_BOLD
            title.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToTop = constLayout.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        adult.apply {
            setTextColor(Color.BLACK)
            adult.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToBottom = title.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }

        }
        backdrop.apply {
            setTextColor(Color.BLACK)
            backdrop.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToBottom = adult.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        backdropImage.apply {
            backdropImage.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToBottom = backdrop.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        belongsToCollection.apply {
            orientation = LinearLayout.VERTICAL
            belongsToCollectionID.setTextColor(Color.BLACK)
            belongsToCollectionName.setTextColor(Color.BLACK)
            belongsToCollection.addView(belongsToCollectionID)
            belongsToCollection.addView(belongsToCollectionName)
            belongsToCollection.addView(belongsToCollectionPoster)
            belongsToCollection.addView(belongsToCollectionBackdrop)
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            belongsToCollection.id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                topToBottom = backdropImage.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }

        }

        budget.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = belongsToCollection.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        genres.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()

                topToBottom = budget.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        homepage.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = genres.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        movieID.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = homepage.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        imdbID.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = movieID.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        originalLanguage.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = imdbID.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        originalTitle.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = originalLanguage.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        overview.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = originalTitle.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        popularity.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = overview.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        posterText.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = popularity.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        posterImage.apply {
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = posterText.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        productionCompanies.apply {
            orientation=LinearLayout.VERTICAL
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = posterImage.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        productionCountries.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = productionCompanies.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        releaseDate.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = productionCountries.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        revenue.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = releaseDate.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        runtime.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = revenue.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        spokenLanguages.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = runtime.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        status.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = spokenLanguages.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        tagline.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = status.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        video.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = tagline.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        voteAverage.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = video.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        voteCount.apply {
            setTextColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = voteAverage.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        reviewsButton.apply {
            text="Reviews"
            layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                id = View.generateViewId()
                topToBottom = voteCount.id
                startToStart = constLayout.id
                endToEnd = constLayout.id
            }
        }
        constLayout.addView(title)
        constLayout.addView(adult)
        constLayout.addView(backdrop)
        constLayout.addView(backdropImage)
        constLayout.addView(belongsToCollection)
        constLayout.addView(budget)
        constLayout.addView(genres)
        constLayout.addView(homepage)
        constLayout.addView(movieID)
        constLayout.addView(imdbID)
        constLayout.addView(originalLanguage)
        constLayout.addView(originalTitle)
        constLayout.addView(overview)
        constLayout.addView(popularity)
        constLayout.addView(posterText)
        constLayout.addView(posterImage)
        constLayout.addView(productionCompanies)
        constLayout.addView(productionCountries)
        constLayout.addView(releaseDate)
        constLayout.addView(revenue)
        constLayout.addView(runtime)
        constLayout.addView(spokenLanguages)
        constLayout.addView(status)
        constLayout.addView(tagline)
        constLayout.addView(video)
        constLayout.addView(voteAverage)
        constLayout.addView(voteCount)
        constLayout.addView(reviewsButton)
        addView(constLayout)
    }
}