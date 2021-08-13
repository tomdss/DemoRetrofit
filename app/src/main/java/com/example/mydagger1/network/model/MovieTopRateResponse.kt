package com.example.mydagger1.network.model

import com.google.gson.annotations.SerializedName

data class MovieTopRateResponse(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<Movie>,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int

)