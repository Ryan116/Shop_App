package com.example.shopapp.features.myCartScreen.domain.useCases

import com.example.shopapp.features.myCartScreen.domain.repository.MyCartScreenRepository

class InsertMyCartToDBUseCase (private val myCartScreenRepository: MyCartScreenRepository) {
    suspend fun insertMyCartToDB() {
        return myCartScreenRepository.insertMyCartToDB()
    }
}