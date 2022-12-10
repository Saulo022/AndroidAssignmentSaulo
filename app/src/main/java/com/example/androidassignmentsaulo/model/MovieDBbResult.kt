package com.example.androidassignmentsaulo.model

data class MovieDBbResult(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)