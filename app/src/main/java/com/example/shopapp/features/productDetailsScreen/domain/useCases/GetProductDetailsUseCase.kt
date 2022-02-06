package com.example.shopapp.features.productDetailsScreen.domain.useCases

import androidx.lifecycle.LiveData
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository

class GetProductDetailsUseCase(private val detailsScreenRepository: DetailsScreenRepository) {
    suspend fun getBestSellerPhonesList(): List<ProductDetailsItem> {
        return detailsScreenRepository.getProductDetails()
    }
}
