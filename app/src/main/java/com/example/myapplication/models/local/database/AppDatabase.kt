package com.example.myapplication.models.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.models.Movie
import com.example.myapplication.models.local.dao.MovieDAO


@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDAO
}