package com.example.myapplication.di

import com.example.myapplication.ui.viewModels.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    //  inject all repositories
    viewModel {
        MoviesViewModel(get(), get())
    }
}