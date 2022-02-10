package com.example.shopapp.features.myCartScreen.data.remote

import com.example.shopapp.features.myCartScreen.data.modelDB.BasketMainDB
import com.example.shopapp.features.myCartScreen.data.network.MyCartApiService
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain


class MyCartRemoteDataSourceImpl(private val myCartApiService: MyCartApiService) :
    MyCartRemoteDataSource {
    override suspend fun getMyCart(): List<BasketMainDB> {
        return myCartApiService.getMyCart()
    }


}