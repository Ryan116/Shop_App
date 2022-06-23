package com.example.shopapp.features.myCartScreen.data.dataSource.remote

import com.example.shopapp.features.myCartScreen.data.network.MyCartApiService
import com.example.shopapp.features.myCartScreen.data.network.modelRemote.BasketMainRemote


class MyCartRemoteDataSourceImpl(private val myCartApiService: MyCartApiService) :
    MyCartRemoteDataSource {
    override suspend fun getMyCartFromServer(): BasketMainRemote {
        return myCartApiService.getMyCart()
    }


}