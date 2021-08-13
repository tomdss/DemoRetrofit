package com.example.mydagger1.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class MovieService {
    companion object Factory {
        fun create(): MovieApi {
            val retrofitMovie = Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofitMovie.create(MovieApi::class.java)
        }
    }
}

