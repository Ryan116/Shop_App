package com.example.shopapp.features.mainScreen.data.network

import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import coil.load
import com.example.shopapp.R
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.model.Main
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.example.shopapp.features.mainScreen.presentation.viewModel.ShopApiStatus
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.DetailsApiStatus

@BindingAdapter("setModel")
fun setModelText(textView: TextView, list: List<HomeStore>?) {
    list?.let {
        textView.text = list.toString()
    }

}

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
fun bindStatus(statusImageView: ImageView, status: DetailsApiStatus?) {
    when (status) {
        DetailsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        DetailsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        DetailsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

