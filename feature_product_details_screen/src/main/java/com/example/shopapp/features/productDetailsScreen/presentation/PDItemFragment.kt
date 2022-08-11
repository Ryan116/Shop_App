package com.example.shopapp.features.productDetailsScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shopapp.common.constants.Constants.PD_IMAGE_POSITION
import com.example.shopapp.common.constants.Constants.RADIUS_ROUNDED_CORNERS_30
import com.example.shopapp.common.extensions.setImageDrawableFromUrl
import com.example.shopapp.features.productDetailsScreen.databinding.FragmentPDItemBinding
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.ProductDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PDItemFragment : Fragment() {

    private var _binding: FragmentPDItemBinding? = null
    private val binding
        get() = _binding!!
    private val pdViewModel by viewModel<ProductDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPDItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillViewPagerItem()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fillViewPagerItem() {
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
                                imageViewPD.setImageDrawableFromUrl(
                                    listImages[i],
                                    RADIUS_ROUNDED_CORNERS_30
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}