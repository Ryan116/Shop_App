package com.example.shopapp.features.bookmarksScreen.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.shopapp.features.bookmarksScreen.domain.model.PhoneBookmark

class BookmarkDiffCallback : DiffUtil.ItemCallback<PhoneBookmark>() {

    override fun areItemsTheSame(oldItem: PhoneBookmark, newItem: PhoneBookmark): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhoneBookmark, newItem: PhoneBookmark): Boolean {
        return oldItem == newItem
    }
}