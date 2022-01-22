package com.example.shopapp.features.mainScreen.data.remote

import com.example.shopapp.features.mainScreen.data.network.ShopMainApiService
import com.example.shopapp.features.mainScreen.domain.model.Main


class RemoteDataSourceImpl(private val shopMainApiService: ShopMainApiService) : RemoteDataSource {

    override suspend fun getPhonesList(): List<Main> {

        return shopMainApiService.getMain()
    }

}