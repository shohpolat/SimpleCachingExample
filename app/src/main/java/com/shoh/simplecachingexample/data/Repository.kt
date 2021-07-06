package com.shoh.simplecachingexample.data

import androidx.room.withTransaction
import com.shoh.simplecachingexample.api.api
import com.shoh.simplecachingexample.db.Database
import com.shoh.simplecachingexample.util.networkBoundResource
import javax.inject.Inject

class Repository
@Inject
constructor(val api: api, val db: Database) {

    private val restaurantDao = db.restaurantDao()

    fun getAllRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            api.getRestaurants()
        },
        saveFetchResult = {
            db.withTransaction {
                restaurantDao.deleteAll()
                restaurantDao.insert(it)
            }
        }
    )

}