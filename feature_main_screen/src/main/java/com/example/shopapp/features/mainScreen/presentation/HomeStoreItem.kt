package com.example.shopapp.features.mainScreen.presentation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shopapp.features.mainScreen.R
import com.example.shopapp.features.mainScreen.databinding.HomeStoreItemBinding
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

const val IMAGE_POSITION = "imagePos"

class HomeStoreItem : Fragment() {
    private lateinit var binding: HomeStoreItemBinding
    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = HomeStoreItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bestSellerLayout.setOnClickListener {
            val uri = Uri.parse("shopapp://ToProductDetailsScreen")
            findNavController().navigate(uri)
        }


        arguments?.takeIf {
            it.containsKey(IMAGE_POSITION)
        }?.apply {
            val position = getInt(IMAGE_POSITION)
            mainViewModel.phones.observe(viewLifecycleOwner) {
                val listSize = it.size
                for (i in 0 until listSize) {
                    when (position) {
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
            }
        }
    }
}

private fun ImageView.setImageFromUrl(imgUrl: String) {
    imgUrl.let {
        this.load(imgUrl) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
            transformations(RoundedCornersTransformation(40f))
        }
    }
}




