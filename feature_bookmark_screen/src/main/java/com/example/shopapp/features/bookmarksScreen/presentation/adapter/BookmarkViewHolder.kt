package com.example.shopapp.features.bookmarksScreen.presentation.adapter

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shopapp.features.bookmarksScreen.R
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
            imageViewBookmark.setImageDrawableFromUrl(bookmark.picture)



        }

    }

}

private fun ImageView.setImageDrawableFromUrl(imgUrl: String) {

    imgUrl.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        this.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}



