package com.axiom.tmdb.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.axiom.tmdb.MainActivity
import com.axiom.tmdb.MyApi
import com.axiom.tmdb.RetrofitHelper
import com.axiom.tmdb.TMDB
import com.axiom.tmdb.adapters.TVShowProductionCompanyAdapter
import com.axiom.tmdb.views.CollectionView
import com.axiom.tmdb.views.MovieView
import com.axiom.tmdb.views.SpecialView
import com.axiom.tmdb.views.TitleDescriptionView


class MovieFragment : Fragment() {
    private var mID: Int = 0
    private lateinit var movieDetails: TMDB.MovieDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Movie Fragment")
        val bundle = arguments
        if (bundle != null && bundle.containsKey("movieID")) {
            mID = bundle.getInt("movieID")
            println("Epiase to bundle")
        } else if (bundle == null) {
            Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show();
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = MovieView(inflater.context)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenResumed {
            val myApi = RetrofitHelper.getInstance().create(MyApi::class.java)
            var response= myApi.getMovieDetails(mID)

            movieDetails=response.body()!!
            var movieView=(view as MovieView)
            movieView.apply {
                (movieMap["title"] as TextView).text=movieDetails.title
                var adultText=if(movieDetails.adult) "Yes" else "No"
                var adult=(movieMap["adult"] as TitleDescriptionView)
                adult.title.text="Adult"
                adult.desc.text=adultText
                (movieMap["backdrop"] as ImageView).load("https://image.tmdb.org/t/p/original"+movieDetails.backdrop_path)
                var collection=(movieMap["collection"] as CollectionView)
                collection.title.text="Collection"
                if(movieDetails.belongs_to_collection!=null) {
                    collection.name.text=movieDetails.belongs_to_collection.name
                    collection.image.load("https://image.tmdb.org/t/p/w300"+movieDetails.belongs_to_collection.backdrop_path)
                    collection.addView(collection.name)
                    collection.addView(collection.image)
                }
                else{
                    collection.unknown.text="No"
                    collection.addView(collection.unknown)
                }
                var budget=(movieMap["budget"] as TitleDescriptionView)
                budget.title.text="Budget"
                budget.desc.text=movieDetails.budget.toString()
                var genresString=""
                if(movieDetails.genres!=null) {
                    for (x in movieDetails.genres) {
                        genresString += x.name +" "
                    }
                }
                else{
                    genresString="No"
                }
                var genres=(movieMap["genres"] as TitleDescriptionView)
                genres.title.text="Genres"
                genres.desc.text=genresString
                var homepage=(movieMap["homepage"] as TitleDescriptionView)
                homepage.title.text="Homepage"
                homepage.desc.text=movieDetails.homepage
                var movieID=(movieMap["movieID"] as TitleDescriptionView)
                movieID.title.text="Movie ID"
                movieID.desc.text= movieDetails.id.toString()
                var originalLanguage=(movieMap["originalLanguage"] as TitleDescriptionView)
                originalLanguage.title.text="Original Language"
                originalLanguage.desc.text= movieDetails.original_language
                var overview=(movieMap["overview"] as TitleDescriptionView)
                overview.title.text="Overview"
                overview.desc.text= movieDetails.overview
                var popularity=(movieMap["popularity"] as TitleDescriptionView)
                popularity.title.text="Popularity"
                popularity.desc.text= movieDetails.popularity.toString()

                var productionCompanies=(movieMap["productionCompanies"] as SpecialView)
                productionCompanies.title.text="Production companies"
                if(movieDetails.production_companies.isEmpty()) {
                    productionCompanies.unknown.text="Unknown"
                    productionCompanies.addView(productionCompanies.unknown)
                }
                else{
                    productionCompanies.addView(productionCompanies.recyclerView)
                    productionCompanies.recyclerView.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    productionCompanies.recyclerView.adapter =
                        TVShowProductionCompanyAdapter(movieDetails.production_companies)
                }


                var prodCountriesNames=""
                if(movieDetails.production_countries.isEmpty()){
                    prodCountriesNames="Unknown"
                }
                else{
                    for((i,x) in movieDetails.production_countries.withIndex()){
                        prodCountriesNames += if(i!=movieDetails.production_countries.size-1)
                            x.name+"/n"
                        else
                            x.name
                    }
                }
                var productionCountries=(movieMap["productionCountries"] as TitleDescriptionView)
                productionCountries.title.text="Production Counties"
                productionCountries.desc.text=prodCountriesNames
                var releaseDate=(movieMap["releaseDate"] as TitleDescriptionView)
                releaseDate.title.text="Release Date"
                releaseDate.desc.text=movieDetails.release_date
                var revenue=(movieMap["revenue"] as TitleDescriptionView)
                revenue.title.text="Revenue"
                revenue.desc.text=movieDetails.revenue.toString()
                var runtime=(movieMap["runtime"] as TitleDescriptionView)
                runtime.title.text="Runtime"
                runtime.desc.text=movieDetails.runtime.toString()

                var spokenLanguagesNames=""
                if(movieDetails.spoken_languages.isEmpty()){
                    spokenLanguagesNames="Unknown"
                }
                else{
                    for((i,x) in movieDetails.spoken_languages.withIndex()){
                        spokenLanguagesNames += if(i!=movieDetails.spoken_languages.size-1)
                            x.english_name+"\n"
                        else
                            x.english_name
                    }
                }
                var spokenLanguages=(movieMap["spokenLanguages"] as TitleDescriptionView)
                spokenLanguages.title.text="Spoken Languages"
                spokenLanguages.desc.text=spokenLanguagesNames
                var status=(movieMap["status"] as TitleDescriptionView)
                status.title.text="Status"
                status.desc.text=movieDetails.status
                var tagline=(movieMap["tagline"] as TitleDescriptionView)
                tagline.title.text="Tagline"
                tagline.desc.text=movieDetails.tagline
                var voteAverage=(movieMap["voteAverage"] as TitleDescriptionView)
                voteAverage.title.text="Vote Average"
                voteAverage.desc.text=movieDetails.vote_average.toString()
                var voteCount=(movieMap["voteCount"] as TitleDescriptionView)
                voteCount.title.text="Vote Count"
                voteCount.desc.text=movieDetails.vote_count.toString()
                var reviewsButton=(movieMap["reviewsButton"] as Button)

                reviewsButton.setOnClickListener {
                    var movieReviewsFragment =
                        MovieReviewsFragment.newInstance(mID, movieDetails.title)

                    (activity as? MainActivity)?.myLayout?.id?.let { it1 ->

                        var transaction =
                            activity?.supportFragmentManager?.beginTransaction()
                        transaction?.replace(it1, movieReviewsFragment)?.commit()
                        transaction?.addToBackStack(null)
                    }
                }
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(id: Int) =
            MovieFragment().apply {
                arguments = Bundle().apply {
                    putInt("movieID", id)
                }
            }
    }
}