package com.shoh.simplecachingexample.api

import com.shoh.simplecachingexample.data.Restaurant
import retrofit2.http.GET

interface api {

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<Restaurant>

}