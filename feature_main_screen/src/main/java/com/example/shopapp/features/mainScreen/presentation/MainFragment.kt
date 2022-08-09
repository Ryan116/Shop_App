package com.example.shopapp.features.mainScreen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopapp.features.mainScreen.R
import com.example.shopapp.features.mainScreen.databinding.FragmentMainBinding
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.presentation.adapters.BestSellerAdapter
import com.example.shopapp.features.mainScreen.presentation.adapters.BookmarkClickListener
import com.example.shopapp.features.mainScreen.presentation.adapters.HomeStorePageAdapter
import com.example.shopapp.features.mainScreen.presentation.state.MainScreenStatus
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding!!

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHomeStoreAdapter()
        setupBestSellerAdapter()
        setupMainScreenStatus()
        setupBottomFilter()
        chooseLocation()
        binding.apply {
            imageButtonPhones.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_category_phones_clicked,
                    R.drawable.ic_button_category_phones,
                    context.getString(R.string.button_category_phones)
                )
            }
            imageButtonComputer.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_category_computer_clicked,
                    R.drawable.ic_button_category_computer,
                    context.getString(R.string.button_category_computers)
                )
            }
            imageButtonHealth.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_category_health_clicked,
                    R.drawable.ic_button_category_health,
                    context.getString(R.string.button_category_health)
                )
            }
            imageButtonBooks.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_category_books_clicked,
                    R.drawable.ic_button_category_books,
                    context.getString(R.string.button_category_books)
                )
            }
            imageButton5.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_category_5_clicked,
                    R.drawable.ic_button_category_5,
                    context.getString(R.string.button_category_button_5)
                )
            }
        }
    }

    private fun chooseLocation() {
        binding.textViewrLocation.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_mapsFragment)
        }
    }

    private fun setupBottomFilter() {
        binding.imageButtonFilter.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.bottom_filter, null)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(view)
            dialog.show()
        }
    }

    private fun setupMainScreenStatus() {
        mainViewModel.status.observe(viewLifecycleOwner) {
            when (it) {
                is MainScreenStatus.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        it.error,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }
    }

    private fun setupBestSellerAdapter() {
        val adapterBS = BestSellerAdapter({
            findNavController().navigate(R.id.action_mainFragment_to_productDetailsFragment)

        },
            object : BookmarkClickListener {
                override fun addBookmark(bestSeller: BestSeller) {
                    mainViewModel.addBookmark(bestSeller)
                }

                override fun deleteBookmark(bestSeller: BestSeller) {
                    mainViewModel.deleteBookmark(bestSeller)
                }

            }
        )
        binding.recyclerViewBestSeller.apply {
            adapter = adapterBS
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        mainViewModel.bestSellerPhonesList.observe(viewLifecycleOwner) {
            adapterBS.submitList(it)
        }
    }

    private fun setupHomeStoreAdapter() {
        mainViewModel.homeStoreListSize.observe(viewLifecycleOwner) {
            val adapterRV = HomeStorePageAdapter(
                requireActivity(),
                listSize = it
            )
            binding.viewPagerHomeStore.adapter = adapterRV
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun categoryButtonClick(
        imageButton: ImageButton,
        clickedImage: Int,
        notClickedImage: Int,
        categoryName: String
    ) {
        imageButton.setOnClickListener { view ->
            mainViewModel.setMenuCategory(categoryName)
            mainViewModel.menuCategory.observe(viewLifecycleOwner) {
                when (mainViewModel.menuCategory.value.equals(categoryName)) {
                    true -> {
                        view.setBackgroundResource(clickedImage)
                    }
                    false -> {
                        view.setBackgroundResource(notClickedImage)
                    }
                }
            }
        }
    }
}