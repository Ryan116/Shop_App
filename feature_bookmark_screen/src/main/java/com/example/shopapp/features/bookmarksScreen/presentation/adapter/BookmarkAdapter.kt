package com.example.shopapp.features.bookmarksScreen.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shopapp.features.bookmarksScreen.databinding.BookmarkItemBinding
import com.example.shopapp.features.bookmarksScreen.domain.model.PhoneBookmark

class BookmarkAdapter(
    private val onItemClicked: (PhoneBookmark) -> Unit,
    private val onBookmarkClicked: (PhoneBookmark) -> Unit
) :
    ListAdapter<PhoneBookmark, BookmarkViewHolder>(BookmarkDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkViewHolder {
        return BookmarkViewHolder(BookmarkItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val bookmark = getItem(position)
        holder.bind(bookmark)
        holder.itemView.setOnClickListener {
            onItemClicked(bookmark)
        }
        holder.bookmark.setOnClickListener {
            onBookmarkClicked(bookmark)
        }
    }
}



