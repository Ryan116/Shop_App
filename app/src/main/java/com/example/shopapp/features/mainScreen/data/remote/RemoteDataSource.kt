package com.example.shopapp.features.mainScreen.data.remote

import com.example.shopapp.features.mainScreen.data.modelDB.BestSellerDB
import com.example.shopapp.features.mainScreen.data.modelDB.HomeStoreDB


interface RemoteDataSource {

    suspend fun getBestSellerPhonesList(): List<BestSellerDB>

    suspend fun getHomeStorePhonesList(): List<HomeStoreDB>

}