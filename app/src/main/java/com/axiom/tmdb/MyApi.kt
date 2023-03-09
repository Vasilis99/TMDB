package com.axiom.tmdb

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface MyApi {

    @GET("movie/top_rated?api_key=287f6ab6616e3724955e2b4c6841ea63")
    suspend fun getTopRatedMovies(): Response<TMDB.Movies>

    @GET("authentication/token/new?api_key=287f6ab6616e3724955e2b4c6841ea63")
    suspend fun getToken(): Response<TMDB.Token>

    @POST("authentication/session/new?api_key=287f6ab6616e3724955e2b4c6841ea63")
    suspend fun getSessionID(@Body token: TMDB.Token): Response<TMDB.Session>

    @GET("{id}?api_key=287f6ab6616e3724955e2b4c6841ea63")
    fun getMovieDetails(@Path("id") movieID:Int): Call<TMDB.MovieDetails>

    @GET("tv/top_rated?api_key=287f6ab6616e3724955e2b4c6841ea63")
    suspend fun getTopTVShows(): Response<TMDB.TVShows>

    @GET("{id}?api_key=287f6ab6616e3724955e2b4c6841ea63")
    fun getTVShowDetails(@Path("id") tvShowID:Int): Call<TMDB.TVShowDetails>

    @GET("movie")
    fun searchMovie(@Query("api_key") apiKey:String,@Query("query") movie:String): Call<TMDB.Movies>

    @GET("tv")
    fun searchTVShow(@Query("api_key") apiKey:String,@Query("query") tvShow:String): Call<TMDB.TVShows>

    @GET("{movieID}/reviews?api_key=287f6ab6616e3724955e2b4c6841ea63")
    fun getMovieReviews(@Path("movieID") movieID:Int): Call<TMDB.MovieReviews>

}