package com.example.shopapp.features.productDetailsScreen.data.dataSource.local

import com.example.shopapp.features.productDetailsScreen.data.cacheDB.database.PDDao
import com.example.shopapp.features.productDetailsScreen.data.cacheDB.modelDB.ProductDetailsItemDB


class PDLocalDataSourceImpl(private val pdDao: PDDao) :
    PDLocalDataSource {

    override suspend fun insertPDItemToCache(productDetailsItemDB: ProductDetailsItemDB) {
        pdDao.insertProductDetails(productDetailsItemDB)
    }

    override suspend fun getProductDetails(): List<ProductDetailsItemDB> {
        return pdDao.getProductDetails()
    }


}