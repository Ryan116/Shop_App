package com.example.shopapp.features.mainScreen.presentation.adapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shopapp.features.mainScreen.R
import com.example.shopapp.features.mainScreen.databinding.BestSellerItemBinding
import com.example.shopapp.features.mainScreen.domain.model.BestSeller

class BestSellerViewHolder(private var binding: BestSellerItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val bookmark = binding.imageViewBSLikes

    fun bind(bestSeller: BestSeller) {
        binding.apply {
            textViewMainTitle.text = bestSeller.title
            textViewDiscountPrice.text = "$${bestSeller.discountPrice}"
            textViewPriceWithourDiscount.text = "$${bestSeller.priceWithoutDiscount}"
            imageViewBestSeller.setImageDrawableFromUrl(bestSeller.picture)



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



