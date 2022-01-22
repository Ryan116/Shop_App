package com.example.shopapp.features.mainScreen.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore

interface MainScreenRepository {

    suspend fun getBestSellerPhonesList(): LiveData<List<BestSeller>>

    suspend fun getHomeStorePhonesList(): LiveData<List<HomeStore>>
}