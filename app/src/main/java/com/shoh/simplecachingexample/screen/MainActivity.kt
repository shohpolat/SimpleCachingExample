package com.shoh.simplecachingexample.screen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.shoh.simplecachingexample.databinding.ActivityMainBinding
import com.shoh.simplecachingexample.util.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<RestaurantViewModel>()
    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            recyclerview.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = this@MainActivity.adapter
                setHasFixedSize(true)
            }
            viewModel.restaurants.observe(this@MainActivity) { result ->
                adapter.submitList(result.data)
                progressBar.isVisible = result is DataState.Loading && result.data.isNullOrEmpty()
                errorText.isVisible = result is DataState.Error && result.data.isNullOrEmpty()
                errorText.text = result.error?.message
            }
        }

    }
}