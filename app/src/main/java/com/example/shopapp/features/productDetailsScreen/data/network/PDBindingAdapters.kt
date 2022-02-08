package com.example.shopapp.features.productDetailsScreen.data.network

import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shopapp.R
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.model.Main
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.example.shopapp.features.mainScreen.presentation.viewModel.ShopApiStatus


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        imgView.load(imgUrl) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
            transformations(RoundedCornersTransformation(40f))
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

