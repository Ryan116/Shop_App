package com.example.shopapp.features.productDetailsScreen.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem

interface DetailsScreenRepository {

    suspend fun getProductDetails(): LiveData<ProductDetailsItem>

    suspend fun insertProductDetailsToCache()
}