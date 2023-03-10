package com.example.myapplication.utils


import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData


internal fun <T> LifecycleOwner.observe(liveData: LiveData<T>, body: (T) -> Unit = {}) {
    val owner = if (this is Fragment) viewLifecycleOwner else this
    liveData.observe(owner, { it?.let { t -> body(t) } })
}

