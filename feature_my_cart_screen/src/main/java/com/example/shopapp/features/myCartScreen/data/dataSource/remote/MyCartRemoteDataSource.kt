package com.example.shopapp.features.myCartScreen.data.dataSource.remote

import com.example.shopapp.features.myCartScreen.data.network.model.BasketMainRemote

interface MyCartRemoteDataSource {

    suspend fun getMyCartFromServer(): BasketMainRemote
}