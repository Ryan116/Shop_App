package com.example.shopapp.features.mainScreen.presentation.adapters

import com.example.shopapp.features.mainScreen.domain.model.BestSeller

interface BookmarkClickListener {

    fun addBookmark(bestSeller: BestSeller)

    fun deleteBookmark(bestSeller: BestSeller)
}