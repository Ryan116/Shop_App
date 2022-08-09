package com.example.shopapp.features.mainScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shopapp.common.constants.Constants.HOME_STORE_ITEM_IMAGE_POSITION
import com.example.shopapp.common.constants.Constants.RADIUS_ROUNDED_CORNERS_30
import com.example.shopapp.common.extensions.setImageDrawableFromUrl
import com.example.shopapp.features.mainScreen.R
import com.example.shopapp.features.mainScreen.databinding.HomeStoreItemBinding
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


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
            findNavController().navigate(R.id.action_mainFragment_to_productDetailsFragment)
        }
        arguments?.takeIf {
            it.containsKey(HOME_STORE_ITEM_IMAGE_POSITION)
        }?.apply {
            val position = getInt(HOME_STORE_ITEM_IMAGE_POSITION)
            mainViewModel.homeStorePhonesList.observe(viewLifecycleOwner) {
                val listSize = it.size
                for (i in 0 until listSize) {
                    when (position) {
                        i -> {
                            val phone = it[i]
                            binding.apply {
                                textViewMainTitle.text = phone.title
                                textViewSubtitle.text = phone.subtitle
                                imageView.setImageDrawableFromUrl(
                                    phone.picture,
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






