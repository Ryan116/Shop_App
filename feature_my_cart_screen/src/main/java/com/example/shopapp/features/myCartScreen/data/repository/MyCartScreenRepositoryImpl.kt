package com.example.shopapp.features.myCartScreen.data.repository

import com.example.shopapp.features.myCartScreen.data.dataSource.local.MyCartLocalDataSource
import com.example.shopapp.features.myCartScreen.data.dataSource.remote.MyCartRemoteDataSource
import com.example.shopapp.features.myCartScreen.data.mapper.MyCartScreenMapper
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.repository.MyCartScreenRepository

class MyCartScreenRepositoryImpl(
    private val myCartRemoteDataSource: MyCartRemoteDataSource,
    private val myCartScreenMapper: MyCartScreenMapper,
    private val myCartLocalDataSource: MyCartLocalDataSource
    ) : MyCartScreenRepository {



    override suspend fun getMyCart(): BasketMain {

        val listBasketMain = myCartScreenMapper.maplistBasketMainDBToListBasketMain(myCartLocalDataSource.getMyCart())
        return listBasketMain[0]
    }

    override suspend fun insertMyCartToDB() {

        val basketMainRemote = myCartRemoteDataSource.getMyCart()
        myCartLocalDataSource.insertMyCartToDB(
            myCartScreenMapper.mapBasketMainRemoteToBasketMainDB(
                basketMainRemote
            )
        )
    }
}