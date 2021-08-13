package com.example.mydagger1.network

import com.example.mydagger1.network.model.MovieTopRateResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MovieApi {
    @GET("movie/top_rated")
    fun getMovieTopRate(@QueryMap user: HashMap<String, Any>): Call<MovieTopRateResponse>
}