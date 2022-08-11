package com.example.shopapp.features.productDetailsScreen.data.dataSource.local

import com.example.shopapp.features.productDetailsScreen.data.cacheDB.modelDB.ProductDetailsItemDB

interface ProductDetailsLocalDataSource {

    suspend fun insertPDItemToCache(productDetailsItemDB: ProductDetailsItemDB)

    suspend fun getProductDetails(): List<ProductDetailsItemDB>
}