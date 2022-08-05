package com.example.shopapp.common.extensions

import android.widget.ImageView
import coil.load
import coil.transform.RoundedCornersTransformation

fun ImageView.setImageDrawableFromUrl(imgUrl: String, radiusRoundedCorners: Float) {
    imgUrl.let {
        this.load(imgUrl) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
            transformations(RoundedCornersTransformation(radiusRoundedCorners))
        }
    }
}