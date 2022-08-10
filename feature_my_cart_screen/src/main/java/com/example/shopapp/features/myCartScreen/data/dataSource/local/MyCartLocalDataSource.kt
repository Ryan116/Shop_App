package com.example.shopapp.features.myCartScreen.data.dataSource.local

import com.example.shopapp.features.myCartScreen.data.cache.model.BasketMainDB

interface MyCartLocalDataSource {

    suspend fun insertMyCartToDB(basketMainDB: BasketMainDB)

    suspend fun getMyCart(): List<BasketMainDB>
}