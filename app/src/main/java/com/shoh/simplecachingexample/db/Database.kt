package com.shoh.simplecachingexample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shoh.simplecachingexample.data.Restaurant

@Database(entities = [Restaurant::class], version = 1)
abstract class Database:RoomDatabase() {
    abstract fun restaurantDao(): Dao
}