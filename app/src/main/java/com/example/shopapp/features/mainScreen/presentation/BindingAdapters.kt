package com.example.shopapp.features.mainScreen.presentation

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.shopapp.R
import com.example.shopapp.features.mainScreen.presentation.viewModel.ShopApiStatus


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        imgView.load(imgUrl) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }

}

@BindingAdapter("shopApiStatus")
fun bindStatus(statusImageView: ImageView, status: ShopApiStatus?) {
    when (status) {
        ShopApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ShopApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ShopApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

