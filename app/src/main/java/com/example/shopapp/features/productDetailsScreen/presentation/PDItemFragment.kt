package com.example.shopapp.features.productDetailsScreen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentPDItemBinding
import com.example.shopapp.databinding.HomeStoreItemBinding
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

const val PD_IMAGE_POSITION = "pdImagePos"

class PDItemFragment : Fragment() {
    private lateinit var binding: FragmentPDItemBinding
    private val pdViewModel by viewModel<DetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPDItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.takeIf {
            it.containsKey(PD_IMAGE_POSITION)
        }?.apply {
            val position = getInt(PD_IMAGE_POSITION)
            pdViewModel.phoneDetailsList.observe(viewLifecycleOwner) {
                val listImages = it[0].images
                val listSize = listImages.size
                for (i in 0 until listSize) {
                    when (position) {
                        i -> {
                            binding.apply {
                                imageViewPD.setImageFromUrl(listImages[i])

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