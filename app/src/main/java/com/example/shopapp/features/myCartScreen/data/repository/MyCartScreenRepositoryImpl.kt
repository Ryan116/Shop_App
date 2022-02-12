package com.example.shopapp.features.myCartScreen.data.repository

import com.example.shopapp.features.myCartScreen.data.mapper.MyCartScreenMapper
import com.example.shopapp.features.myCartScreen.data.remote.MyCartRemoteDataSource
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.repository.MyCartScreenRepository

class MyCartScreenRepositoryImpl(
    private val myCartRemoteDataSource: MyCartRemoteDataSource,
    private val myCartScreenMapper: MyCartScreenMapper
    ) :
    MyCartScreenRepository {



    override suspend fun getMyCart(): List<BasketMain> {
        return myCartScreenMapper.mapListBasketMainDBToBasketMain(myCartRemoteDataSource.getMyCart())
    }
}