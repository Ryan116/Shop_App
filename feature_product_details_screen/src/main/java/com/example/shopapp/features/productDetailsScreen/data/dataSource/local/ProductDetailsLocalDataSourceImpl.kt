package com.example.shopapp.features.productDetailsScreen.data.dataSource.local

import com.example.shopapp.features.productDetailsScreen.data.cacheDB.database.ProductDetailsDao
import com.example.shopapp.features.productDetailsScreen.data.cacheDB.modelDB.ProductDetailsItemDB

class ProductDetailsLocalDataSourceImpl(private val productDetailsDao: ProductDetailsDao) :
    ProductDetailsLocalDataSource {

    override suspend fun insertPDItemToCache(productDetailsItemDB: ProductDetailsItemDB) {
        productDetailsDao.insertProductDetails(productDetailsItemDB)
    }

    override suspend fun getProductDetails(): List<ProductDetailsItemDB> {
        return productDetailsDao.getProductDetails()
    }
}