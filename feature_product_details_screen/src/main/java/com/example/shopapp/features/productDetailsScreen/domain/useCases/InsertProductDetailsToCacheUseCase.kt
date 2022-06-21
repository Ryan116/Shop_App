package com.example.shopapp.features.productDetailsScreen.domain.useCases

import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository

class InsertProductDetailsToCacheUseCase(private val detailsScreenRepository: DetailsScreenRepository) {
    suspend fun insertProductDetailsToCache() {
        return detailsScreenRepository.insertProductDetailsToCache()
    }
}