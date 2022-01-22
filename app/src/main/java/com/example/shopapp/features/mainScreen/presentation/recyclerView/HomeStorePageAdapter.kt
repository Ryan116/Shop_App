package com.example.shopapp.features.mainScreen.presentation.recyclerView

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shopapp.features.mainScreen.presentation.IMAGE_POSITION
import com.example.shopapp.features.mainScreen.presentation.ImageFragment

class HomeStorePageAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val imageFragment = ImageFragment()
        imageFragment.arguments = Bundle().apply {
            putInt(IMAGE_POSITION, position)
        }
        return imageFragment
    }
}