package com.example.shopapp.features.mainScreen.presentation

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopapp.features.mainScreen.R
import com.example.shopapp.features.mainScreen.databinding.FragmentMainBinding
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
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




        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
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
//            when (clicked) {
//                true -> {
//                    clicked = false
//                    imageButton.setBackgroundResource(clickedImage)
//                }
//                false -> {
//                    clicked = true
//                    imageButton.setBackgroundResource(notClickedImage)
//                }
//            }
        }
    }

//    imageButtonPhones.setOnClickListener { view ->
//        mainViewModel.setMenuCategory("Phones")
//        mainViewModel.menuCategory.observe(viewLifecycleOwner) { categoryName ->
//            when (mainViewModel.menuCategory.value.equals(categoryName)) {
//                true -> {
//                    view.setBackgroundResource(R.drawable.ic_button_phones_clicked)
//                }
//                false -> {
//                    view.setBackgroundResource(R.drawable.ic_button_phones)
//                }
//            }
//        }
//    }

}