package com.example.androidassignmentsaulo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignmentsaulo.databinding.MovieItemBinding

class MoviesAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int { return movies.size }

    class ViewHolder(private val binding: MovieItemBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.movieTitle.text = movie.title
        }
    }
}