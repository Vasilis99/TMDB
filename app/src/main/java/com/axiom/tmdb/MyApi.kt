package com.axiom.tmdb

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface MyApi {

    @GET("movie/top_rated?api_key=287f6ab6616e3724955e2b4c6841ea63")
    suspend fun getTopRatedMovies(): Response<TMDB.TopRatedMovies>

    @GET("authentication/token/new?api_key=287f6ab6616e3724955e2b4c6841ea63")
    suspend fun getToken(): Response<TMDB.Token>

    @POST("authentication/session/new?api_key=287f6ab6616e3724955e2b4c6841ea63")
    suspend fun getSessionID(@Body token: TMDB.Token): Response<TMDB.Session>

    @GET("{id}?api_key=287f6ab6616e3724955e2b4c6841ea63")
    fun getMovieDetails(@Path("id") movieID:Int): Call<TMDB.MovieDetails>

    @GET("tv/top_rated?api_key=287f6ab6616e3724955e2b4c6841ea63")
    suspend fun getTopTVShows(): Response<TMDB.TopRatedTVShows>

    @GET("{id}?api_key=287f6ab6616e3724955e2b4c6841ea63")
    fun getTVShowDetails(@Path("id") tvShowID:Int): Call<TMDB.TVShowDetails>

    @GET("movie?api_key=287f6ab6616e3724955e2b4c6841ea63&query={movie}")
    fun searchMovie(@Path("movie") movie:String): Call<TMDB.MovieBasic>

}