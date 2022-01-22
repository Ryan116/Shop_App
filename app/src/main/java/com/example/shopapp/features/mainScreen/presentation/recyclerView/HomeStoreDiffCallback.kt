package com.example.shopapp.features.mainScreen.presentation.recyclerView

import androidx.recyclerview.widget.DiffUtil
import com.example.shopapp.features.mainScreen.domain.model.HomeStore

class HomeStoreDiffCallback:DiffUtil.ItemCallback<HomeStore>() {
    override fun areItemsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem == newItem
    }
}