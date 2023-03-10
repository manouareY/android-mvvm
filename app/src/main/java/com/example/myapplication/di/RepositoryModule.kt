package com.example.myapplication.di

import androidx.room.Room
import com.example.myapplication.models.local.dao.MovieDAO
import com.example.myapplication.models.local.database.AppDatabase
import com.example.myapplication.repositories.local.MoviesDaoRepositoryImp
import com.example.myapplication.repositories.remote.MoviesRepositoryImp
import org.koin.android.ext.koin.androidApplication
import org.koin.core.scope.Scope
import org.koin.dsl.ScopeDSL

import org.koin.dsl.module
import retrofit2.Retrofit


val repositoryModule = module {
 //  inject all repositories

    single {
        MoviesRepositoryImp(get())
    }
    single {
        MoviesDaoRepositoryImp(get())
    }
}