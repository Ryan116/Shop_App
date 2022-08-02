package com.example.shopapp.features.mainScreen.domain.useCases


import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.repository.MainRepository


class AddBookmarkUseCase(private val mainRepository: MainRepository) {
    suspend fun addBookmark(bestSeller: BestSeller) {
        mainRepository.addBookmark(bestSeller)
    }
}