package com.shoh.simplecachingexample.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shoh.simplecachingexample.data.Restaurant
import com.shoh.simplecachingexample.databinding.ListitemRestaurantBinding

class Adapter : ListAdapter<Restaurant, Adapter.ViewHolder>(ItemComparator()) {

    inner class ViewHolder(val binding: ListitemRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(index: Int) {
            val currentItem = getItem(index)
            binding.apply {
                Glide.with(itemView).load(currentItem.logo).into(imageView)
                restaurantName.text = currentItem.name
                restaurantDescription.text = currentItem.description
                restaurantType.text = currentItem.type
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListitemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    class ItemComparator : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }


    }

}