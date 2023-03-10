package com.example.myapplication.repositories

import com.example.myapplication.models.Movie


interface MoviesRepository {
    suspend fun loadMovies() : List<Movie>
    suspend fun persistMovies(movies: List<Movie>)

}