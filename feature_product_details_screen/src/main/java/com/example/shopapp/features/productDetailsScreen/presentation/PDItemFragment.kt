package com.example.shopapp.features.productDetailsScreen.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shopapp.common.extensions.setImageDrawableFromUrl
import com.example.shopapp.features.productDetailsScreen.databinding.FragmentPDItemBinding
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
                val listImages = it.images
                val listSize = listImages.size
                for (i in 0 until listSize) {
                    when (position) {
                        i -> {
                            binding.apply {
                                imageViewPD.setImageDrawableFromUrl(listImages[i], 30f)

                            }
                        }
                    }
                }
            }
        }
    }
}