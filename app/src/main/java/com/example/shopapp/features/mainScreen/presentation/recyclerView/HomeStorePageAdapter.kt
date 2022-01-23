package com.example.shopapp.features.mainScreen.presentation.recyclerView

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.presentation.IMAGE_POSITION
import com.example.shopapp.features.mainScreen.presentation.ImageFragment

const val IMAGE_URL = "imageUrl"

class HomeStorePageAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    private var listHomeStore = mutableListOf<HomeStore>()
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val imageFragment = ImageFragment()
        imageFragment.arguments = Bundle().apply {
            putInt(IMAGE_POSITION, position)
            putString(IMAGE_URL, listHomeStore[position].picture)
        }
        return imageFragment
    }

    fun postList(list2: List<HomeStore>) {
        listHomeStore = list2 as MutableList<HomeStore>
    }
}