package com.example.roomdatabasepractice.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String,
    val note : String
)
