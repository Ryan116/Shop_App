package com.example.shopapp.features.productDetailsScreen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentMainBinding
import com.example.shopapp.databinding.FragmentProductDetailsBinding
import com.example.shopapp.features.mainScreen.presentation.recyclerView.HomeStorePageAdapter
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.example.shopapp.features.productDetailsScreen.presentation.adapters.PDPageAdapter
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.DetailsViewModel


class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private val productDetailsViewModel: DetailsViewModel by viewModels()

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

    }


}

private fun ImageView.setImageResource(imgUrl: String) {
    imgUrl.let {
        this.load(imgUrl) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
            transformations(RoundedCornersTransformation(40f))
        }
    }
}


