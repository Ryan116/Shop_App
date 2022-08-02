package com.example.shopapp.features.bookmarksScreen.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shopapp.features.bookmarksScreen.R
import com.example.shopapp.features.bookmarksScreen.databinding.BookmarkItemBinding
import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark

class BookmarkAdapter(
    private val onItemClicked: (Bookmark) -> Unit,
    private val bookmarkClickListener: BookmarkClickListener
) :
    ListAdapter<Bookmark, BookmarkViewHolder>(BookmarkDiffCallback()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkViewHolder {
        return BookmarkViewHolder(BookmarkItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val bookmark = getItem(position)
        holder.bind(bookmark)
        var pressed = true
        holder.itemView.setOnClickListener {
            onItemClicked(bookmark)
        }
        holder.bookmark.setOnClickListener {
            if (pressed) {
                pressed = false
                holder.bookmark.setImageResource(R.drawable.ic_bslike_empty)
                bookmarkClickListener.deleteBookmark(bookmark)
            } else {
                pressed = true
                holder.bookmark.setImageResource(R.drawable.ic_bestseller)
            }



        }

    }

    interface BookmarkClickListener {
        fun deleteBookmark(bookmark: Bookmark)
    }
}



