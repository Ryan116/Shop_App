package com.example.shopapp.features.mainScreen.domain.useCases


import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository

class DeleteBookmarkUseCase(private val mainScreenRepository: MainScreenRepository) {
    suspend fun deleteBookmark(bestSeller: BestSeller) {
        mainScreenRepository.deleteBookmark(bestSeller)
    }
}
