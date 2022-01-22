package com.example.shopapp.features.mainScreen.presentation.recyclerView

import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.example.shopapp.R
import com.example.shopapp.databinding.HomeStoreItemBinding
import com.example.shopapp.features.mainScreen.domain.model.HomeStore

//class HomeStoreViewHolder(private var binding: HomeStoreItemBinding) :
//    RecyclerView.ViewHolder(binding.root) {
//    val homeStoreLayout: ConstraintLayout = binding.homeStoreLayout
//    fun bind(homeStore: HomeStore) {
//        binding.apply {
//            buttonBuyNow.text = homeStore.isBuy.toString()
//            textViewMainTitle.text = homeStore.title
//            textViewSubtitle.text = homeStore.subtitle
//            imageView.setImageDrawableFromUrl(homeStore.picture)
//
//
//        }
//
//    }
//
//}

//private fun ViewPager2.setImageDrawableFromUrl(imgUrl: String) {
//
//    imgUrl.let {
//        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
//        this.load(imgUri) {
//            placeholder(R.drawable.loading_animation)
//            error(R.drawable.ic_broken_image)
//        }
//    }
//
//
//}



