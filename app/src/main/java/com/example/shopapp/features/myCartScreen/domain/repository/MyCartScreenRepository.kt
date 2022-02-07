package com.example.shopapp.features.myCartScreen.domain.repository

import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem

interface MyCartScreenRepository {
    suspend fun getMyCart(): List<BasketMain>
}

