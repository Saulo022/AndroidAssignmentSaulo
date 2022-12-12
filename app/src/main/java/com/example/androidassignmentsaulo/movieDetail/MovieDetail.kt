package com.example.androidassignmentsaulo.movieDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
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

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        if (movie != null) {
            title = movie.title
            Glide
                .with(this)
                .load("https://image.tmdb.org/t/p/w780/${movie.backdrop_path}")
                .into(binding.backdrop)
            binding.Title.text = movie.title
            binding.overview.text = movie.overview
            bindDetailInfo(binding.detailInfo, movie)
        }
    }

    private fun bindDetailInfo(detailInfo: TextView, movie: Movie) {
        detailInfo.text = buildSpannedString {
            bold { append("Original title: ")}
            appendLine(movie.original_title)

            bold { append("Original language: ")}
            appendLine(movie.original_language)

            bold { append("Release date: ")}
            appendLine(movie.release_date)

            bold { append("Popularity: ")}
            appendLine(movie.popularity.toString())

            bold { append("Vote Average: ")}
            appendLine(movie.vote_average.toString())
        }
    }
}