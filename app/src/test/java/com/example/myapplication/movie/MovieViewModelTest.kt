package com.example.myapplication.movie

import com.example.myapplication.repositories.local.MoviesDaoRepositoryImp
import com.example.myapplication.repositories.remote.MoviesRepositoryImp
import com.example.myapplication.ui.viewModels.MoviesViewModel
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class MovieViewModelTest {

    private val _moviesRepositoryImp: MoviesRepositoryImp = mockk() // I used Mockk for mocking, but you can use any other mocking framework
    private val _moviesDaoRepositoryImp: MoviesDaoRepositoryImp = mockk() // I used Mockk for mocking, but you can use any other mocking framework

    private val _movieViewModel = MoviesViewModel(_moviesRepositoryImp, _moviesDaoRepositoryImp)

    @Test
    fun doGetMovies_test() {
    }
}