package com.example.androidassignmentsaulo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.androidassignmentsaulo.databinding.ActivityMainBinding
import com.example.androidassignmentsaulo.model.Movie
import com.example.androidassignmentsaulo.model.MovieDbClient
import com.example.androidassignmentsaulo.model.MovieDbService
import com.example.androidassignmentsaulo.movieDetail.MovieDetail
import com.example.androidassignmentsaulo.viewModel.MovieViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val movieViewModel: MovieViewModel by viewModels()

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

    /*
    fun searchByName(query:String) {
        CoroutineScope(Dispatchers.IO).launch {
            val apiKey = getString(R.string.api_key)
            val call = MovieDbClient.service.listPopularMovies(apiKey)


            val movies: List<Movie> = call.results

            for ((index, item) in movies.withIndex()){
                if (movies[index].title == query){

                }
            }
        }

    }*/

}