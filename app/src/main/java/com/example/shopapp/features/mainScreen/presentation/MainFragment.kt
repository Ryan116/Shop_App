package com.example.shopapp.features.mainScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentMainBinding
import com.example.shopapp.features.mainScreen.presentation.recyclerView.BestSellerAdapter
import com.example.shopapp.features.mainScreen.presentation.recyclerView.HomeStorePageAdapter
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog


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
        mainViewModel.phones.observe(viewLifecycleOwner) {
            mainViewModel.homeStoreListSize.value = it.size
            val adapterRV = HomeStorePageAdapter(
                requireActivity(),
                listSize = mainViewModel.homeStoreListSize.value ?: 0,

            )
            binding.viewPagerHomeStore.adapter = adapterRV
        }
        mainViewModel.bestSellerPhonesList.observe(viewLifecycleOwner) {
            mainViewModel.bestSellerListSize.value = it.size
            val adapterBS = BestSellerAdapter() {
                if (view != null) {
                    Navigation.findNavController(requireView())
                        .navigate(R.id.action_mainFragment_to_productDetailsFragment)
                }


            }
            adapterBS.submitList(it)
            binding.recyclerViewBestSeller.adapter = adapterBS
            binding.recyclerViewBestSeller.layoutManager = GridLayoutManager(requireContext(), 2)

        }
        binding.apply {
            imageButtonPhones.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_phones_clicked,
                    R.drawable.ic_button_phones,
                    getString(R.string.category_phones)
                )
            }
            imageButtonComputer.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_computer_clicked,
                    R.drawable.ic_button_computer,
                    getString(R.string.category_computer)
                )
            }
            imageButtonHealth.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_health_clicked,
                    R.drawable.ic_button_health,
                    getString(R.string.category_health)
                )
            }
            imageButtonBooks.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_books_clicked,
                    R.drawable.ic_button_books,
                    getString(R.string.category_books)
                )
            }
            imageButton5.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_5_clicked,
                    R.drawable.ic_button_5,
                    getString(R.string.category_button_5)
                )
            }
        }
        binding.imageButtonFilter.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.bottom_filter, null)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(view)
            dialog.show()
        }




        return binding.root
    }

    private fun categoryButtonClick(
        imageButton: ImageButton,
        clickedImage: Int,
        notClickedImage: Int,
        buttonClickedName: String
    ) {
        var clicked = true
        imageButton.setOnClickListener {
            when (clicked) {
                true -> {
                    clicked = false
                    imageButton.setBackgroundResource(clickedImage)
                }
                false -> {
                    clicked = true
                    imageButton.setBackgroundResource(notClickedImage)
                }
            }
        }
    }

}