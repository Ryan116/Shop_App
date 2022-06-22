package com.example.shopapp.features.productDetailsScreen.domain.useCases

import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository

class InsertProductDetailsToDBUseCase(private val detailsScreenRepository: DetailsScreenRepository) {
    suspend fun insertProductDetailsToCache() {
        return detailsScreenRepository.insertProductDetailsToCache()
    }
}