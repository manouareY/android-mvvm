package com.example.myapplication.adapter.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.MoviesRecyclerCellBinding
import com.example.myapplication.models.Movie


class MoviesListAdapter(private val movies: ArrayList<Movie>, private val onItemClicked: (Movie) -> Unit, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: MoviesRecyclerCellBinding


    override fun getItemCount(): Int {
        return movies.size
    }

    private fun getItem(position: Int): Movie {
        return movies[position]
    }

    // Inflates the item views
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        binding = MoviesRecyclerCellBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return MovieCellViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as MovieCellViewHolder).bind( getItem(position))
        viewHolder.itemView.setOnClickListener{
            onItemClicked(getItem(position))
        }

    }

}

class MovieCellViewHolder(private val binding: MoviesRecyclerCellBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.movieTitle.text = movie.title
    }

}

