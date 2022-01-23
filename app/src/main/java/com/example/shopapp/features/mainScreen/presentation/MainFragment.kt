package com.example.shopapp.features.mainScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.shopapp.R
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.presentation.recyclerView.HomeStorePageAdapter
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel


class MainFragment : Fragment() {
    private lateinit var adapterRV: HomeStorePageAdapter
    //    private lateinit var binding: FragmentMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        binding = FragmentMainBinding.inflate(inflater)
//        binding.apply {
//            viewModel = mainViewModel
//            lifecycleOwner = this@MainFragment
//
//
//        }



        return inflater.inflate(R.layout.home_store_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list1 = listOf<HomeStore>(
            HomeStore(0, "", "", "123", true),
            HomeStore(1, "", "", "345", true),
            HomeStore(2, "", "", "3456", true)
        )
        adapterRV =
            HomeStorePageAdapter(requireActivity())
        mainViewModel.phones.observe(viewLifecycleOwner, {
            adapterRV.postList(it)

        })
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPagerTest)
        viewPager.adapter = adapterRV
//        binding.recyclerViewHomeStore.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//        binding.recyclerViewHomeStore.adapter = adapterRV
    }
}