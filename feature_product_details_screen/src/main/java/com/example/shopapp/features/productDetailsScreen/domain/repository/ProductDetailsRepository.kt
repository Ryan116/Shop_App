package com.example.shopapp.features.productDetailsScreen.domain.repository

import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem

interface ProductDetailsRepository {

    suspend fun getProductDetails(): ProductDetailsItem

    suspend fun insertProductDetailsToCache()
}