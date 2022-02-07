package com.example.shopapp.features.myCartScreen.data.remote

import com.example.shopapp.features.myCartScreen.domain.model.BasketMain


interface MyCartRemoteDataSource {

    suspend fun getMyCart() : List<BasketMain>

}