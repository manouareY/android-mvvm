package com.example.myapplication.models.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.models.Movie


@Dao
interface MovieDAO {
    @Query("SELECT * FROM movie")
     suspend fun getAll(): List<Movie>

    @Insert
    suspend fun insertAll(vararg movies: Movie)

    @Delete
    suspend fun delete(movie: Movie)
}
