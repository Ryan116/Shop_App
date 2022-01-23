package com.example.shopapp.features.mainScreen.presentation.recyclerView

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shopapp.features.mainScreen.presentation.IMAGE_POSITION
import com.example.shopapp.features.mainScreen.presentation.ImageFragment
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel

class HomeStorePageAdapter(fragment: FragmentActivity, private val listSize: Int): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = listSize

    override fun createFragment(position: Int): Fragment {
        val imageFragment = ImageFragment()
        imageFragment.arguments = Bundle().apply {
            putInt(IMAGE_POSITION, position)
        }
        return imageFragment
    }
}