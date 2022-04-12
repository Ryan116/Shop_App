package com.example.shopapp.features.myCartScreen.data.remote

import com.example.shopapp.features.myCartScreen.data.modelDB.BasketMainDB


interface MyCartRemoteDataSource {

    suspend fun getMyCart() : BasketMainDB

}