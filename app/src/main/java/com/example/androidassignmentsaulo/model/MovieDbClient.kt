package com.example.androidassignmentsaulo.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieDbClient {

    //This instance of Retrofit that we are going to create will be the one
    // with the rest of the url of the endpoint, it will be in charge of converting the JSON
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(MovieDbService::class.java)
}