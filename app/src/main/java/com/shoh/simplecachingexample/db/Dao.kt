package com.shoh.simplecachingexample.db

import androidx.room.*
import androidx.room.Dao
import com.shoh.simplecachingexample.data.Restaurant
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<Restaurant>)

    @Query("DELETE FROM restaurant")
    fun deleteAll()

    @Query("SELECT * FROM restaurant")
    fun getAllRestaurants(): Flow<List<Restaurant>>

}