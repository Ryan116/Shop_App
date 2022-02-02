package com.example.shopapp.features.productDetailsScreen.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore

interface DetailsScreenRepository {

    suspend fun getProductDetails(): List<BestSeller>
}