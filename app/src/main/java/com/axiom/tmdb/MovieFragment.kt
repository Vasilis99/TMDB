package com.axiom.tmdb

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MovieFragment : Fragment() {
    private val vm by viewModels<MovieViewModel>()
    private var movieID: Int = 0
    private lateinit var movieDetails:TMDB.MovieDetails
    object RetrofitHelper {
        private const val baseUrl = "https://api.themoviedb.org/3/movie/"
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle != null && bundle.containsKey("movieID")) {
            movieID = bundle.getInt("movieID")
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
            val myApi = MovieFragment.RetrofitHelper.getInstance().create(MyApi::class.java)
            var call= myApi.getMovieDetails(movieID)

            call.enqueue(object : Callback<TMDB.MovieDetails> {
                override fun onResponse(call: Call<TMDB.MovieDetails>, response: Response<TMDB.MovieDetails>) {
                    if (!response.isSuccessful) {
                        println("Response not successful. Code: " + response.code())
                        return
                    }
                    println("Response successful"+response.body()?.id)
                    movieDetails=response.body()!!
                    var movieView=(view as MovieView)
                    movieView.apply {
                        title.text=movieDetails.title
                        var adultText=if(movieDetails.adult) "Yes" else "No"
                        adult.text=Html.fromHtml("<p><b>Adult</b><br>$adultText</p>",1)
                        backdrop.text="Backdrop image"
                        var url1="https://image.tmdb.org/t/p/original"+movieDetails.backdrop_path
                        backdropImage.load(url1)
                        if(movieDetails.belongs_to_collection!=null) {
                            belongsToCollectionID.text = Html.fromHtml("<p><b>Collection ID</b><br>" + movieDetails.belongs_to_collection.id + "</p>",1)
                            belongsToCollectionName.text=Html.fromHtml("<p><b>Collection Name</b><br>" + movieDetails.belongs_to_collection.name+"</p>",1)
                            var url2="https://image.tmdb.org/t/p/original"+movieDetails.belongs_to_collection.poster_path
                            belongsToCollectionPoster.load(url2)
                            var url3="https://image.tmdb.org/t/p/original"+movieDetails.belongs_to_collection.backdrop_path
                            belongsToCollectionBackdrop.load(url3)
                        }
                        else{
                            belongsToCollectionID.text=Html.fromHtml("<p><b>Collection</b><br>" +"No" + "</p>",1)
                        }
                        budget.text=Html.fromHtml("<p><b>Budget</b><br>"+movieDetails.budget+"</p>",1)
                        var genresString=""
                        if(movieDetails.genres!=null) {
                            for (x in movieDetails.genres) {
                                genresString += x.name +" "
                            }

                        }
                        else{
                            genresString="No"
                        }
                        genres.text=Html.fromHtml("<p><b>Genres</b><br>$genresString</p>",1)
                        homepage.text=Html.fromHtml("<p><b>Homepage</b><br>${movieDetails.homepage}</p>",1)
                        movieID.text=Html.fromHtml("<p><b>ID</b><br>${movieDetails.id}</p>",1)
                        imdbID.text=Html.fromHtml("<p><b>imdb id</b><br>${movieDetails.imdb_id}</p>",1)
                        originalLanguage.text=Html.fromHtml("<p><b>Original language</b><br>${movieDetails.original_language}</p>",1)
                        originalTitle.text=Html.fromHtml("<p><b>Original title</b><br>${movieDetails.original_title}</p>",1)
                        overview.text=Html.fromHtml("<p><b>Overview</b><br>${movieDetails.overview}</p>",1)
                        popularity.text=Html.fromHtml("<p><b>Popularity</b><br>${movieDetails.popularity}</p>",1)
                        if(movieDetails.production_companies!=null){
                            var prodComp=TextView(context)
                            prodComp.id=View.generateViewId()
                            prodComp.text="Production companies"
                            prodComp.setTextColor(Color.BLACK)
                            prodComp.typeface= Typeface.DEFAULT_BOLD
                            productionCompanies.addView(prodComp)
                            for(x in movieDetails.production_companies){
                                var prodCompName=TextView(context)
                                prodCompName.id=View.generateViewId()
                                prodCompName.setTextColor(Color.BLACK)
                                prodCompName.text=Html.fromHtml("<p><b>Name</b><br>${x.name}</p>",1)
                                productionCompanies.addView(prodCompName)
                                var prodCompID=TextView(context)
                                prodCompID.id=View.generateViewId()
                                prodCompID.setTextColor(Color.BLACK)
                                prodCompID.text=Html.fromHtml("<p><b>ID</b><br>${x.id}</p>",1)
                                productionCompanies.addView(prodCompID)
                                var prodCompOrigCountry=TextView(context)
                                prodCompOrigCountry.id=View.generateViewId()
                                prodCompOrigCountry.setTextColor(Color.BLACK)
                                prodCompOrigCountry.text=Html.fromHtml("<p><b>Origin Country</b><br>${x.origin_country}</p>",1)
                                productionCompanies.addView(prodCompOrigCountry)
                                var prodCompLogo=ImageView(context)
                                prodCompLogo.id=View.generateViewId()
                                var url4="https://image.tmdb.org/t/p/original"+x.logo_path
                                prodCompLogo.load(url4)
                                productionCompanies.addView(prodCompLogo)

                            }
                        }
                        else{
                            var prodComp=TextView(context)
                            prodComp.id=View.generateViewId()
                            prodComp.text=Html.fromHtml("<p><b>Production Companies</b><br>"+"Unknown"+"</p>",1)
                            prodComp.setTextColor(Color.BLACK)
                            productionCompanies.addView(prodComp)
                        }

                        var prodCountriesNames=""
                        if(movieDetails.production_countries!=null){
                            for((i,x) in movieDetails.production_countries.withIndex()){
                                prodCountriesNames += if(i!=movieDetails.production_countries.size-1)
                                    x.name+"/n"
                                else
                                    x.name
                            }
                        }
                        else{
                            prodCountriesNames="Unknown"
                        }
                        productionCountries.text=Html.fromHtml("<p><b>Production Counties</b><br>$prodCountriesNames</p>",1)
                        productionCountries.setTextColor(Color.BLACK)
                        releaseDate.text=Html.fromHtml("<p><b>Release date</b><br>${movieDetails.release_date}</p>",1)
                        revenue.text=Html.fromHtml("<p><b>Revenue</b><br>${movieDetails.revenue}</p>",1)
                        runtime.text=Html.fromHtml("<p><b>Runtime</b><br>${movieDetails.runtime}</p>",1)
                        var spokenLanguagesNames=""
                        if(movieDetails.spoken_languages!=null){
                            for((i,x) in movieDetails.spoken_languages.withIndex()){
                                spokenLanguagesNames += if(i!=movieDetails.spoken_languages.size-1)
                                    x.english_name+"\n"
                                else
                                    x.english_name
                            }
                        }
                        else{
                            spokenLanguagesNames="Unknown"
                        }
                        spokenLanguages.text=Html.fromHtml("<p><b>Spoken Languages</b><br>$spokenLanguagesNames</p>",1)
                        status.text=Html.fromHtml("<p><b>Status</b><br>${movieDetails.status}</p>",1)
                        tagline.text=Html.fromHtml("<p><b>Tagline</b><br>${movieDetails.tagline}</p>",1)
                        var videoText=if(movieDetails.video) "Yes" else "No"
                        video.text=Html.fromHtml("<p><b>Video</b><br>$videoText</p>",1)
                        voteAverage.text=Html.fromHtml("<p><b>Vote average</b><br>${movieDetails.vote_average}</p>",1)
                        voteCount.text=Html.fromHtml("<p><b>Vote count</b><br>${movieDetails.vote_count}</p>",1)
                    }



                }

                override fun onFailure(call: Call<TMDB.MovieDetails>, t: Throwable) {
                    println("on Failure $t")
                }
            })

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