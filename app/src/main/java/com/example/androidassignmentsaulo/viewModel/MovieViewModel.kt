package com.example.androidassignmentsaulo.viewModel

import androidx.lifecycle.*
import com.example.androidassignmentsaulo.R
import com.example.androidassignmentsaulo.model.Movie
import com.example.androidassignmentsaulo.model.MovieDbClient
import kotlinx.coroutines.launch

class MovieViewModel(apiKey: String) : ViewModel() {


     val _movies = MutableLiveData<List<Movie>>()
}