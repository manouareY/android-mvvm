package com.example.myapplication.di

import androidx.room.Room
import com.example.myapplication.models.local.dao.MovieDAO
import com.example.myapplication.models.local.database.AppDatabase
import com.example.myapplication.utils.Constant
import org.koin.android.ext.koin.androidApplication

import org.koin.dsl.module


val databaseModule = module {

    single<AppDatabase> {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java, Constant.DATABASE_NAME
        ).build()
    }

    single<MovieDAO> {  get<AppDatabase>().getMovieDao() }

}
