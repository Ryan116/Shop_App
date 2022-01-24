package com.example.shopapp.features.mainScreen.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopapp.databinding.FragmentMainBinding
import com.example.shopapp.features.mainScreen.presentation.recyclerView.BestSellerAdapter
import com.example.shopapp.features.mainScreen.presentation.recyclerView.HomeStorePageAdapter
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        binding.apply {
            viewModel = mainViewModel
            lifecycleOwner = this@MainFragment


        }
        mainViewModel.phones.observe(viewLifecycleOwner, {
            mainViewModel.homeStoreListSize.value = it.size
            binding.textView1.text = mainViewModel.homeStoreListSize.value.toString()
            val adapterRV = HomeStorePageAdapter(requireActivity(), listSize = mainViewModel.homeStoreListSize.value?:0)
            binding.viewPagerHomeStore.adapter = adapterRV
        })
        mainViewModel.bestSellerPhonesList.observe(viewLifecycleOwner, {
            mainViewModel.bestSellerListSize.value = it.size
            val adapterBS = BestSellerAdapter()
            adapterBS.submitList(it)
            binding.recyclerViewBestSeller.adapter = adapterBS
            binding.recyclerViewBestSeller.layoutManager = GridLayoutManager(requireContext(), 2)

        })

        return binding.root
    }

}