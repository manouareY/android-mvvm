package com.example.myapplication.repositories.local

import com.example.myapplication.models.local.dao.MovieDAO
import com.example.myapplication.models.Movie
import com.example.myapplication.models.local.database.AppDatabase
import com.example.myapplication.repositories.MoviesRepository
import com.example.myapplication.service.MoviesApiService
import org.koin.java.KoinJavaComponent
import timber.log.Timber


class MoviesDaoRepositoryImp(private val movieDAO: MovieDAO) : MoviesRepository{

    override suspend fun loadMovies(): List<Movie> {
        var movies = movieDAO.getAll()
        Timber.d("MovieRepositoryImp : response of movies service :  %s", movies)
        return movies
    }

    override suspend fun persistMovies(movies: List<Movie>) {
        movieDAO.insertAll(*movies.toTypedArray())
    }
}