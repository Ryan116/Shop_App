package com.example.shopapp.features.myCartScreen.data.dataSource.local

import com.example.shopapp.features.myCartScreen.data.cache.database.MyCartDao
import com.example.shopapp.features.myCartScreen.data.cache.model.BasketMainDB

class MyCartLocalDataSourceImpl(private val myCartDao: MyCartDao) :
    MyCartLocalDataSource {

    override suspend fun insertMyCartToDB(basketMainDB: BasketMainDB) {
        myCartDao.insertMyCart(basketMainDB)
    }

    override suspend fun getMyCart(): List<BasketMainDB> {
        return myCartDao.getMyCart()
    }
}