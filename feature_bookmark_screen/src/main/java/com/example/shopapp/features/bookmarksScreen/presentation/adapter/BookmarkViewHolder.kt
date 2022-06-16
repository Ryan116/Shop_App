package com.example.shopapp.features.bookmarksScreen.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.shopapp.common.extensions.setImageDrawableFromUrl
import com.example.shopapp.features.bookmarksScreen.databinding.BookmarkItemBinding
import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark

class BookmarkViewHolder(private var binding: BookmarkItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val bookmark = binding.imageViewBSLikes

    fun bind(bookmark: Bookmark) {
        binding.apply {
            textViewMainTitle.text = bookmark.title
            textViewDiscountPrice.text = "$${bookmark.discountPrice}"
            textViewPriceWithourDiscount.text = "$${bookmark.priceWithoutDiscount}"
            imageViewBookmark.setImageDrawableFromUrl(bookmark.picture, 30f)



        }

    }
}





