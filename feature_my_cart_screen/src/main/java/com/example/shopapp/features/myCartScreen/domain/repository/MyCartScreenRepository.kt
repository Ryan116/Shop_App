package com.example.shopapp.features.myCartScreen.domain.repository

import com.example.shopapp.features.myCartScreen.domain.model.BasketMain

interface MyCartScreenRepository {
    suspend fun getMyCart(): BasketMain

    suspend fun insertMyCartToDB()
}

