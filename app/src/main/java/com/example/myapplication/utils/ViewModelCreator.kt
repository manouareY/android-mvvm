package com.example.myapplication.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider



internal inline fun <reified T : ViewModel> Fragment.viewModel(
        crossinline provider: () -> T
) = viewModels<T> {
    object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return provider() as T
        }
    }
}

internal inline fun <reified T : ViewModel> Fragment.activityViewModel(
        crossinline provider: () -> T
) = activityViewModels<T> {
    object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return provider() as T
        }
    }
}