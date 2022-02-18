package com.example.shopapp.features.productDetailsScreen.presentation.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shopapp.features.productDetailsScreen.presentation.PDItemFragment
import com.example.shopapp.features.productDetailsScreen.presentation.PD_IMAGE_POSITION

class PDPageAdapter(fragment: FragmentActivity, private val listSize: Int): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = listSize

    override fun createFragment(position: Int): Fragment {
        val imageFragment = PDItemFragment()
        imageFragment.arguments = Bundle().apply {
            putInt(PD_IMAGE_POSITION, position)
        }
        return imageFragment
    }
}