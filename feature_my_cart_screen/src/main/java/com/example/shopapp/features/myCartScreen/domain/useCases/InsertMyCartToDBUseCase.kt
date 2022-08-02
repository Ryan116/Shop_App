package com.example.shopapp.features.myCartScreen.domain.useCases

import com.example.shopapp.features.myCartScreen.domain.repository.MyCartRepository

class InsertMyCartToDBUseCase (private val myCartRepository: MyCartRepository) {
    suspend fun insertMyCartToDB() {
        return myCartRepository.insertMyCartToDB()
    }
}