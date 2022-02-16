package com.example.shopapp.features.myCartScreen.domain.useCases

import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.repository.MyCartScreenRepository

class GetMyCartUseCase(private val myCartScreenRepository: MyCartScreenRepository) {
    suspend fun getMyCart(): List<BasketMain> {
        return myCartScreenRepository.getMyCart()
    }
}


