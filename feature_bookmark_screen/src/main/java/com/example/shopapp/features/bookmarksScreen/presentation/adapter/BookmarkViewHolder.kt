package com.example.shopapp.features.bookmarksScreen.presentation.adapter

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.shopapp.common.constants.Constants.RADIUS_ROUNDED_CORNERS_30
import com.example.shopapp.common.extensions.setImageDrawableFromUrl
import com.example.shopapp.features.bookmarksScreen.databinding.BookmarkItemBinding
import com.example.shopapp.features.bookmarksScreen.domain.model.PhoneBookmark

class BookmarkViewHolder(private var binding: BookmarkItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val bookmark = binding.imageViewBookmarkAddButton
    fun bind(phoneBookmark: PhoneBookmark) {
        binding.apply {
            textViewMainTitle.text = phoneBookmark.title
            textViewDiscountPrice.text = "$${phoneBookmark.priceWithoutDiscount}"
            textViewPriceWithoutDiscount.text = "$${phoneBookmark.discountPrice}"
            textViewPriceWithoutDiscount.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            imageViewBookmark.setImageDrawableFromUrl(
                phoneBookmark.picture,
                RADIUS_ROUNDED_CORNERS_30
            )
        }
    }
}





