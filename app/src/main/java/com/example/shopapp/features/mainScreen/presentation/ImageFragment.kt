package com.example.shopapp.features.mainScreen.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentImageBinding
import com.example.shopapp.databinding.FragmentMainBinding
import com.example.shopapp.features.mainScreen.presentation.recyclerView.IMAGE_URL
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.squareup.picasso.Picasso
import java.net.URL

const val IMAGE_POSITION = "imagePos"

class ImageFragment : Fragment() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return layoutInflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val picasso = Picasso.get()
        val list = mainViewModel.phones.value
        val imageView = view.findViewById<ImageView>(R.id.imageViewHomeStore)

        arguments?.takeIf {
            it.containsKey(IMAGE_POSITION)
            it.containsKey(IMAGE_URL)
        }?.apply {

            when(getInt(IMAGE_POSITION)) {
                0 -> {
//                    val url = URL(this.getString(IMAGE_URL))
//                    picasso.load(url.path).into(imageView)
                    Log.d("logUrl", getString(IMAGE_URL).toString())
                }
                1 -> {
//                    val url = URL(this.getString(IMAGE_URL))
//                    picasso.load(url.path).into(imageView)
                    Log.d("logUrl", getString(IMAGE_URL).toString())
                }
                2 -> {
//                    val url = URL(this.getString(IMAGE_URL))
//                    picasso.load(url.path).into(imageView)
                    Log.d("logUrl", getString(IMAGE_URL).toString())
                }

            }
        }
    }



}