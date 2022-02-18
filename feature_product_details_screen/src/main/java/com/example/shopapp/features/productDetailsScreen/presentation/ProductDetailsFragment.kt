package com.example.shopapp.features.productDetailsScreen.presentation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shopapp.features.productDetailsScreen.R
import com.example.shopapp.features.productDetailsScreen.databinding.FragmentProductDetailsBinding
import com.example.shopapp.features.productDetailsScreen.presentation.adapters.PDPageAdapter
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private val productDetailsViewModel by viewModel<DetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productDetailsViewModel.phoneDetailsList.observe(viewLifecycleOwner) {
            var phoneItemList = it
            val phoneItem = phoneItemList?.get(0)
            phoneItem?.let {
                binding.apply {
                    textViewPDPhoneTitle.text = phoneItem.title
                    textViewCpu.text = phoneItem.cpu
                    textViewCamera.text = phoneItem.camera
                    textViewRam.text = phoneItem.ssd
                    textViewStorage.text = phoneItem.sd
                    textView128GB.text = phoneItem.capacity[0]
                    textView256GB.text = phoneItem.capacity[1]
                }
            }
            val adapterPD = PDPageAdapter(requireActivity(), 3)
            binding.viewPagerPD.adapter = adapterPD
        }

        binding.apply {
            buttonMyCart.setOnClickListener {
                val uri = Uri.parse("shopapp://ToMyCart")
                findNavController().navigate(uri)
//                Navigation.findNavController(requireView())
//                    .navigate(R.id.action_productDetailsFragment_to_myCartFragment)
            }


        }

    }


}




