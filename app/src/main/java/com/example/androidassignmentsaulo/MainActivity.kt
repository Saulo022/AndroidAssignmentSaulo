package com.example.androidassignmentsaulo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidassignmentsaulo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMovies.adapter = MoviesAdapter(
            listOf(
                Movie("Title 1", "url 1"),
                Movie("Title 2", "url 2"),
                Movie("Title 3", "url 3"),
                Movie("Title 4", "url 4"),
                Movie("Title 5", "url 5"),
                Movie("Title 6", "url 6")
            )
        )
    }
}