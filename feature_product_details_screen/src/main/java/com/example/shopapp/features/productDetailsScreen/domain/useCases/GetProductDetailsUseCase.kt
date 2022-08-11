package com.example.shopapp.features.productDetailsScreen.domain.useCases

import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.repository.ProductDetailsRepository

class GetProductDetailsUseCase(private val productDetailsRepository: ProductDetailsRepository) {

    suspend fun getProductDetails(): ProductDetailsItem {
        return productDetailsRepository.getProductDetails()
    }
}
