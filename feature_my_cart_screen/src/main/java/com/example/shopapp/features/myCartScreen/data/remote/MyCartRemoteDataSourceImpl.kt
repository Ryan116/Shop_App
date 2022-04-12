package com.example.shopapp.features.myCartScreen.data.remote

import com.example.shopapp.features.myCartScreen.data.modelDB.BasketMainDB
import com.example.shopapp.features.myCartScreen.data.network.MyCartApiService


class MyCartRemoteDataSourceImpl(private val myCartApiService: MyCartApiService) :
    MyCartRemoteDataSource {
    override suspend fun getMyCart(): BasketMainDB {
        return myCartApiService.getMyCart()
    }


}