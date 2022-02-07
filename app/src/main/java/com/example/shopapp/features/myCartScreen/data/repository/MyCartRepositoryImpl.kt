package com.example.shopapp.features.myCartScreen.data.repository

import com.example.shopapp.features.myCartScreen.data.remote.MyCartRemoteDataSource
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.repository.MyCartScreenRepository
import com.example.shopapp.features.productDetailsScreen.data.remote.DetailsRemoteDataSource
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository

class MyCartRepositoryImpl(private val myCartRemoteDataSource: MyCartRemoteDataSource) :
    MyCartScreenRepository {

    override suspend fun getMyCart(): List<BasketMain> {
        return myCartRemoteDataSource.getMyCart()
    }
}