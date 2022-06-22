package com.example.shopapp.features.myCartScreen.data.dataSource.remote

import com.example.shopapp.features.myCartScreen.data.network.modelRemote.BasketMainRemote


interface MyCartRemoteDataSource {

    suspend fun getMyCart() : BasketMainRemote

}