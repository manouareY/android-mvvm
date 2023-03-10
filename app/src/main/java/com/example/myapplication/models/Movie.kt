package com.example.myapplication.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
 data class Movie(
    @PrimaryKey(autoGenerate = true) val mid: Int?,
    val title: String?,
    val posterUrl: String?,
    val director: String?,
    val year: Int?
):Parcelable