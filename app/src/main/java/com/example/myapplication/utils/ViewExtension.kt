package com.example.myapplication.utils

import android.view.View

fun View.gone(){
    visibility = View.GONE
}

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.isVisible(){
    visibility == View.VISIBLE
}

fun View.isGone(){
    visibility == View.GONE
}