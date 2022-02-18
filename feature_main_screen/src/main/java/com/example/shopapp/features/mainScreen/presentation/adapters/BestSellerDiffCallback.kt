package com.example.shopapp.features.mainScreen.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.shopapp.features.mainScreen.domain.model.BestSeller

class BestSellerDiffCallback:DiffUtil.ItemCallback<BestSeller>() {
    override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem == newItem
    }
}