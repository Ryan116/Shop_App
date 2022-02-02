package com.example.shopapp.features.mainScreen.data.network

import android.content.Context
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

@BindingAdapter("setModel")
fun setModelText(textView: TextView, list: List<HomeStore>?) {
    list?.let {
        textView.text = list.toString()
    }

}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }

}

