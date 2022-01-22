package com.example.shopapp.features.mainScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopapp.databinding.FragmentMainBinding
import com.example.shopapp.features.mainScreen.presentation.recyclerView.HomeStoreAdapter
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
        val adapterRV = HomeStoreAdapter()
        binding.recyclerViewHomeStore.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewHomeStore.adapter = adapterRV
        mainViewModel.phones.observe(viewLifecycleOwner, {
            binding.textView1.text = it.toString()
            adapterRV.submitList(it)
        })

        return binding.root
    }

}