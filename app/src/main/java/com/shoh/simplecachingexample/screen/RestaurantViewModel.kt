package com.shoh.simplecachingexample.screen

import androidx.lifecycle.*
import com.shoh.simplecachingexample.data.Repository
import com.shoh.simplecachingexample.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    val restaurants = repository.getAllRestaurants().asLiveData()

}