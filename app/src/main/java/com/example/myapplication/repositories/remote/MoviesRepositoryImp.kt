package com.example.myapplication.repositories.remote

import com.example.myapplication.models.Movie
import com.example.myapplication.repositories.MoviesRepository
import com.example.myapplication.service.MoviesApiService
import org.koin.java.KoinJavaComponent
import timber.log.Timber


class MoviesRepositoryImp(private val _movieApiService: MoviesApiService) : MoviesRepository {

    override suspend fun loadMovies(): List<Movie> {
        var movies = _movieApiService.loadMovies()
        Timber.d("MovieRepositoryImp : response of movies service :  %s", movies)
        return movies
    }

    override suspend fun persistMovies(movies: List<Movie>) {
        // we can use it to persist data to a remote database
    }
}