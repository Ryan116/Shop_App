package com.example.shopapp.features.myCartScreen.data.repository

import com.example.shopapp.features.myCartScreen.data.dataSource.local.MyCartLocalDataSource
import com.example.shopapp.features.myCartScreen.data.dataSource.remote.MyCartRemoteDataSource
import com.example.shopapp.features.myCartScreen.data.mapper.MyCartMapper
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.repository.MyCartRepository

class MyCartRepositoryImpl(
    private val myCartRemoteDataSource: MyCartRemoteDataSource,
    private val myCartMapper: MyCartMapper,
    private val myCartLocalDataSource: MyCartLocalDataSource
) : MyCartRepository {

    override suspend fun getMyCart(): BasketMain {
        val listBasketMain =
            myCartMapper.mapListBasketMainDBToListBasketMain(myCartLocalDataSource.getMyCart())
        return listBasketMain[0]
    }

    override suspend fun insertMyCartToDB() {
        val basketMainRemote = myCartRemoteDataSource.getMyCartFromServer()
        myCartLocalDataSource.insertMyCartToDB(
            myCartMapper.mapBasketMainRemoteToBasketMainDB(
                basketMainRemote
            )
        )
    }
}