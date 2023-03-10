package com.example.myapplication.service


import com.example.myapplication.BuildConfig
import com.example.myapplication.models.Movie
import retrofit2.http.GET
import retrofit2.http.Headers

interface MoviesApiService {

    @Headers("Accept: application/json")

    @GET(BuildConfig.LOAD_MOVIES_API_URL)
    suspend fun loadMovies() : List<Movie>

}