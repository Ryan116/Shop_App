package com.example.shopapp.features.productDetailsScreen.domain.useCases

import com.example.shopapp.features.productDetailsScreen.domain.repository.ProductDetailsRepository

class InsertProductDetailsToDBUseCase(private val productDetailsRepository: ProductDetailsRepository) {

    suspend fun insertProductDetailsToCache() {
        return productDetailsRepository.insertProductDetailsToCache()
    }
}