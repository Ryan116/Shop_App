package com.example.shopapp.features.mainScreen.presentation

import android.net.Uri
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
import com.example.shopapp.features.mainScreen.presentation.adapters.HomeStorePageAdapter
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.example.shopapp.features.mainScreen.presentation.viewModel.ShopApiStatus
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
            val adapterBS = BestSellerAdapter({
                if (view != null) {
                    val uri = Uri.parse("shopapp://ToProductDetailsScreen")
                    findNavController().navigate(uri)
                }
            },
                object : BestSellerAdapter.BookmarkClickListener {
                    override fun addBookmark(bestSeller: BestSeller) {
                        mainViewModel.addBookmark(bestSeller)
                    }

                    override fun deleteBookmark(bestSeller: BestSeller) {
                        mainViewModel.deleteBookmark(bestSeller)
                    }

                }
            )
            adapterBS.submitList(it)
            binding.recyclerViewBestSeller.adapter = adapterBS
            binding.recyclerViewBestSeller.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        mainViewModel.status.observe(viewLifecycleOwner) {
            when (it) {
                is ShopApiStatus.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        "We can't load images! Exception: ${ShopApiStatus.ERROR().exception}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }

        binding.apply {
            imageButtonPhones.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_phones_clicked,
                    R.drawable.ic_button_phones,
                    "Phones"
                )
            }
            imageButtonComputer.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_computer_clicked,
                    R.drawable.ic_button_computer,
                    "Computers"
                )
            }
            imageButtonHealth.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_health_clicked,
                    R.drawable.ic_button_health,
                    "Health"
                )
            }
            imageButtonBooks.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_books_clicked,
                    R.drawable.ic_button_books,
                    "Books"
                )
            }
            imageButton5.apply {
                categoryButtonClick(
                    this,
                    R.drawable.ic_button_5_clicked,
                    R.drawable.ic_button_5,
                    "Button_5"
                )
            }
        }

        binding.imageButtonFilter.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.bottom_filter, null)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(view)
            dialog.show()
        }


        binding.textViewrLocation.setOnClickListener {
            val uri = Uri.parse("shopapp://ToMapScreen")
            findNavController().navigate(uri)
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