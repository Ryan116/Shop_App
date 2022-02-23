package com.example.shopapp.features.mainScreen.presentation

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopapp.features.mainScreen.R
import com.example.shopapp.features.mainScreen.databinding.FragmentMainBinding
import com.example.shopapp.features.mainScreen.presentation.adapters.BestSellerAdapter
import com.example.shopapp.features.mainScreen.presentation.adapters.HomeStorePageAdapter
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
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
            val adapterBS = BestSellerAdapter {
                if (view != null) {
                    val uri = Uri.parse("shopapp://ToProductDetailsScreen")
                    findNavController().navigate(uri)
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

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item2 -> {
                    val uri = Uri.parse("shopapp://ToMyCart")
                    findNavController().navigate(uri)
                }
            }
            true
        }
        binding.textViewrLocation.setOnClickListener {
            val uri = Uri.parse("shopapp://ToMapScreen")
            findNavController().navigate(uri)
        }




        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
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