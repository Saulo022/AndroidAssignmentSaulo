package com.example.androidassignmentsaulo.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbService {


    @GET("movie/popular")
    suspend fun listPopularMovies(@Query("api_key") apiKey: String): MovieDBbResult
}