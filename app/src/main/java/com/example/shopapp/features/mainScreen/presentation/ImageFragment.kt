package com.example.shopapp.features.mainScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentImageBinding
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.squareup.picasso.Picasso

const val IMAGE_POSITION = "imagePos"

class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentImageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val picasso = Picasso.get()


        arguments?.takeIf {
            it.containsKey(IMAGE_POSITION)
        }?.apply {
            val position = getInt(IMAGE_POSITION)
            mainViewModel.phones.observe(viewLifecycleOwner, {
                val listSize = it.size
                for (i in 0 until listSize) {
                    when(position) {
                        i -> {
                            val phone = it[i]
                            binding.apply {
                                textViewMainTitle.text = phone.title
                                textViewSubtitle.text = phone.subtitle
                                imageView.setImageFromUrl(phone.picture)
                            }
                        }
                    }
                }


            })


        }
    }





}

private fun ImageView.setImageFromUrl(imgUrl: String) {
    imgUrl.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        this.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}


