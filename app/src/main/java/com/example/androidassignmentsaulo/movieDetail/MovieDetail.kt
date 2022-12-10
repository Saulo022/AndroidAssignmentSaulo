package com.example.androidassignmentsaulo.movieDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.androidassignmentsaulo.R
import com.example.androidassignmentsaulo.databinding.ActivityMovieDetailBinding
import com.example.androidassignmentsaulo.model.Movie

@Suppress("DEPRECATION")
class MovieDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "MovieDetail:movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        if (movie != null) {
            binding.titleDetail.text = movie.title
            Glide
                .with(this)
                .load("https://image.tmdb.org/t/p/w780/${movie.backdrop_path}")
                .into(binding.backdrop)
        }
    }
}