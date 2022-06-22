package com.example.shopapp.features.myCartScreen.data.dataSource.local

import com.example.shopapp.features.myCartScreen.data.cacheDB.modelDB.BasketMainDB


interface MyCartLocalDataSource {

    suspend fun insertMyCartToDB(basketMainDB: BasketMainDB)

    suspend fun getMyCart(): List<BasketMainDB>

}