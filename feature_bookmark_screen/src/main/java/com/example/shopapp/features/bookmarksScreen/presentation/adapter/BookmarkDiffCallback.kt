package com.example.shopapp.features.bookmarksScreen.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark

class BookmarkDiffCallback:DiffUtil.ItemCallback<Bookmark>() {
    override fun areItemsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
        return oldItem == newItem
    }
}