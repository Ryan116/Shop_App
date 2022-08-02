package com.example.shopapp.features.myCartScreen.domain.useCases

import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.repository.MyCartRepository

class GetMyCartUseCase(private val myCartRepository: MyCartRepository) {
    suspend fun getMyCart(): BasketMain {
        return myCartRepository.getMyCart()
    }
}


