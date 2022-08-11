package com.example.shopapp.features.productDetailsScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shopapp.features.productDetailsScreen.R
import com.example.shopapp.features.productDetailsScreen.databinding.FragmentProductDetailsBinding
import com.example.shopapp.features.productDetailsScreen.presentation.adapters.PDPageAdapter
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.ProductDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val productDetailsViewModel by viewModel<ProductDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productDetailsViewModel.phoneDetailsList.observe(viewLifecycleOwner) {
            it?.let {
                binding.apply {
                    textViewPDPhoneTitle.text = it.title
                    textViewCpu.text = it.cpu
                    textViewCamera.text = it.camera
                    textViewRam.text = it.ssd
                    textViewStorage.text = it.sd
                    textView128GB.text = it.capacity[0]
                    textView256GB.text = it.capacity[1]
                }
            }
            val adapterPD = PDPageAdapter(requireActivity(), it.images.size)
            binding.viewPagerPD.adapter = adapterPD
        }

        setupButtonMyCart()
        setupPDScreenState()
    }

    private fun setupPDScreenState() {
        productDetailsViewModel.status.observe(viewLifecycleOwner) {
            when (it) {
                is DetailsApiStatus.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        it.error,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                else -> {}
            }
        }
    }

    private fun setupButtonMyCart() {
        binding.apply {
            buttonMyCart.setOnClickListener {
                findNavController().navigate(R.id.action_productDetailsFragment_to_myCartFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




