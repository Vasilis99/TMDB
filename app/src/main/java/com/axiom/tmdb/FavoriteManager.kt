package com.axiom.tmdb

import android.content.Context
import androidx.preference.PreferenceManager

class FavoriteManager(val context: Context) {
    fun addMovieFavorite(movieID:Int){
        val shared = PreferenceManager.getDefaultSharedPreferences(context)
        shared.edit().putBoolean("m$movieID",true).apply()
    }
    fun deleteMovieFavorite(movieID:Int){
        val shared = PreferenceManager.getDefaultSharedPreferences(context)
        shared.edit().remove("m$movieID").apply()
    }
    fun getMoviesFavorites():ArrayList<Int>{
        val shared=PreferenceManager.getDefaultSharedPreferences(context)
        val moviesFavorites=ArrayList<Int>()
        for (x in shared.all){
            if(x.key.first()=='m') {
                var movieID = x.key.substring(1, x.key.length).toInt()
                moviesFavorites.add(movieID)
            }
        }
        return moviesFavorites
    }
    fun addTVShowFavorite(tvShowID:Int){
        val shared = PreferenceManager.getDefaultSharedPreferences(context)
        shared.edit().putBoolean("t$tvShowID",true).apply()
    }
    fun deleteTVShowFavorite(tvShowID:Int){
        val shared = PreferenceManager.getDefaultSharedPreferences(context)
        shared.edit().remove("t$tvShowID").apply()
    }
    fun getTVShowsFavorites():ArrayList<Int>{
        val shared=PreferenceManager.getDefaultSharedPreferences(context)
        val tvShowsFavorites=ArrayList<Int>()
        for (x in shared.all){
            if(x.key.first()=='t') {
                var tvShowID = x.key.substring(1, x.key.length).toInt()
                tvShowsFavorites.add(tvShowID)
            }
        }
        return tvShowsFavorites
    }
}