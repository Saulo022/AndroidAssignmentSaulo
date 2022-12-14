package com.example.androidassignmentsaulo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidassignmentsaulo.databinding.MovieItemBinding
import com.example.androidassignmentsaulo.model.Movie


class MoviesAdapter(
    var movies: List<Movie>,
    private val movieClickedListener: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { movieClickedListener(movie) }
    }

    override fun getItemCount(): Int { return movies.size }

    class ViewHolder(private val binding: MovieItemBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.movieTitle.text = movie.title
            binding.descrip.text = movie.overview
            Glide
                .with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w780/${movie.poster_path}")
                .into(binding.imageView)
        }
    }
}