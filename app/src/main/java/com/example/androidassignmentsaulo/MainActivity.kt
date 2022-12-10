package com.example.androidassignmentsaulo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.androidassignmentsaulo.databinding.ActivityMainBinding
import com.example.androidassignmentsaulo.model.Movie
import com.example.androidassignmentsaulo.model.MovieDbClient
import com.example.androidassignmentsaulo.movieDetail.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val moviesAdapter = MoviesAdapter(emptyList()) { navigateTo(it) }
        binding.rvMovies.adapter = moviesAdapter

        lifecycleScope.launch {
            val apiKey = getString(R.string.api_key)
            val popularMovies = MovieDbClient.service.listPopularMovies(apiKey)
            moviesAdapter.movies = popularMovies.results
            moviesAdapter.notifyDataSetChanged()
        }
    }


    private fun navigateTo(movie: Movie) {
        //Navigate to MovieDetail and pass object movie to it.
        val intent = Intent(this, MovieDetail::class.java)
        intent.putExtra(MovieDetail.EXTRA_MOVIE, movie)
        startActivity(intent)
    }
}