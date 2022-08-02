package com.example.shopapp.features.mainScreen.domain.repository

import com.example.shopapp.features.mainScreen.data.network.modelRemote.MainRemote
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore

interface MainRepository {

    suspend fun getBestSellerPhonesList(): List<BestSeller>

    suspend fun getHomeStorePhonesList(): List<HomeStore>

    suspend fun addBookmark(bestSeller: BestSeller)

    suspend fun deleteBookmark(bestSeller: BestSeller)

    suspend fun insertMainRemoteToDB()
}