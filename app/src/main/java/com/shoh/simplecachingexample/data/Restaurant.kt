package com.shoh.simplecachingexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant")
data class Restaurant(
    @PrimaryKey val name: String,
    val type: String? = null,
    val description: String? = null,
    val logo: String? = null
)