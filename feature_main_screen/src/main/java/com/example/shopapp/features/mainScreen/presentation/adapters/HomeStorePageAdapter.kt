package com.example.shopapp.features.mainScreen.presentation.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shopapp.features.mainScreen.presentation.HomeStoreItem
import com.example.shopapp.features.mainScreen.presentation.IMAGE_POSITION

class HomeStorePageAdapter(fragment: FragmentActivity, private val listSize: Int): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = listSize

    override fun createFragment(position: Int): Fragment {
        val imageFragment = HomeStoreItem()
        imageFragment.arguments = Bundle().apply {
            putInt(IMAGE_POSITION, position)
        }
        return imageFragment
    }
}