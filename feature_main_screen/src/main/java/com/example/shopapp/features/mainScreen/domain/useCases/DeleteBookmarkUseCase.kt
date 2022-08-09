package com.example.shopapp.features.mainScreen.domain.useCases

import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.repository.MainRepository

class DeleteBookmarkUseCase(private val mainRepository: MainRepository) {

    suspend fun deleteBookmark(bestSeller: BestSeller) {
        mainRepository.deleteBookmark(bestSeller)
    }
}
