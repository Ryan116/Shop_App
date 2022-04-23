package com.example.shopapp.features.mainScreen.domain.useCases


import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository


class AddBookmarkUseCase(private val mainScreenRepository: MainScreenRepository) {
    suspend fun addBookmark(bestSeller: BestSeller) {
        mainScreenRepository.addBookmark(bestSeller)
    }
}