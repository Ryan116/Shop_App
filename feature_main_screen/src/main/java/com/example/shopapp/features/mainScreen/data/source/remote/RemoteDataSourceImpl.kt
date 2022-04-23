package com.example.shopapp.features.mainScreen.data.source.remote

import com.example.shopapp.features.mainScreen.data.modelDB.BestSellerDB
import com.example.shopapp.features.mainScreen.data.modelDB.HomeStoreDB
import com.example.shopapp.features.mainScreen.data.network.ShopMainApiService


class RemoteDataSourceImpl(private val shopMainApiService: ShopMainApiService) : RemoteDataSource {

    override suspend fun getBestSellerPhonesList(): List<BestSellerDB> {
        return shopMainApiService.getMain().bestSeller
    }

    override suspend fun getHomeStorePhonesList(): List<HomeStoreDB> {
        return shopMainApiService.getMain().homeStore
    }

}