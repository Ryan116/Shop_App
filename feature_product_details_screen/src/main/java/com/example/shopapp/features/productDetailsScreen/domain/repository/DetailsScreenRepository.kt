package com.example.shopapp.features.productDetailsScreen.domain.repository

import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem

interface DetailsScreenRepository {

    suspend fun getProductDetails(): ProductDetailsItem

    suspend fun insertProductDetailsToCache()
}