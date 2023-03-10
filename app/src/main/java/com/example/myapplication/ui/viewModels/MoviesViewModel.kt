package com.example.myapplication.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.Movie
import com.example.myapplication.repositories.local.MoviesDaoRepositoryImp
import com.example.myapplication.repositories.remote.MoviesRepositoryImp
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import timber.log.Timber
import java.lang.Exception

class MoviesViewModel(private val _moviesRepository: MoviesRepositoryImp, private val _moviesDAORepository:MoviesDaoRepositoryImp) : ViewModel() {

    val _movies = MutableLiveData<ArrayList<Movie>>()

    fun doGetMovies() {
        viewModelScope.launch {
            Timber.d("start coroutine scoop")
            // show a loader
            try {
                _movies.postValue(_moviesRepository.loadMovies() as ArrayList<Movie>?)
            }catch ( e : Exception){
               Timber.e(e)
            }finally {
                // hide a loader
                Timber.d("end coroutine scoop")
            }
        }

    }

    fun persistMovies(movies: List<Movie>) {
        viewModelScope.launch {
            Timber.d("start coroutine scoop")
            // show a loader
            try {
                _moviesDAORepository.persistMovies(movies)
            }catch ( e : Exception){
                Timber.e(e)
            }finally {
                // hide a loader
                Timber.d("end coroutine scoop")
            }
        }

    }

}