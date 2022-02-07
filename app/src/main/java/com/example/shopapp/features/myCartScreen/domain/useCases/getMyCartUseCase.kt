package com.example.shopapp.features.myCartScreen.domain.useCases

import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.repository.MyCartScreenRepository
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository

class getMyCartUseCase(private val myCartScreenRepository: MyCartScreenRepository) {
    suspend fun getMyCart(): List<BasketMain> {
        return myCartScreenRepository.getMyCart()
    }
}


