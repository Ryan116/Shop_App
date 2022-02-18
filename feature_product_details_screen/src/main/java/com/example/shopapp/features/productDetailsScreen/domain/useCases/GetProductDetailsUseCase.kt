package com.example.shopapp.features.productDetailsScreen.domain.useCases

import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository

class GetProductDetailsUseCase(private val detailsScreenRepository: DetailsScreenRepository) {
    suspend fun getProductDetails(): List<ProductDetailsItem> {
        return detailsScreenRepository.getProductDetails()
    }
}
