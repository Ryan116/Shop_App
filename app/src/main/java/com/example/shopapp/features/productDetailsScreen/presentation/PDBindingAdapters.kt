package com.example.shopapp.features.productDetailsScreen.presentation

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shopapp.R
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.DetailsApiStatus


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

@BindingAdapter("detailsApiStatus")
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

