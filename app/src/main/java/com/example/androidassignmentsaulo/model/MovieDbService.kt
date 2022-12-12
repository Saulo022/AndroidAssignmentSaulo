package com.example.androidassignmentsaulo.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbService {

    //simpler requests, they only return information. If we need to pass a parameter
    // to the request it will be through the url.
    @GET("movie/popular")

    //method to be used by Retrofit
    suspend fun listPopularMovies(@Query("api_key") apiKey: String): MovieDBbResult
}