package com.example.shopapp.features.mainScreen.domain.repository

import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore

interface MainScreenRepository {

    suspend fun getBestSellerPhonesList(): List<BestSeller>

    suspend fun getHomeStorePhonesList(): List<HomeStore>
}