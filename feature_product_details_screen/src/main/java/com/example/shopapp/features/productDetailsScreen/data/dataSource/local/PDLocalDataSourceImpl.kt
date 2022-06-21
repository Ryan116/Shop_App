package com.example.shopapp.features.productDetailsScreen.data.dataSource.local

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.shopapp.features.productDetailsScreen.data.cacheDB.database.PDCacheDao
import com.example.shopapp.features.productDetailsScreen.data.cacheDB.modelDB.ProductDetailsItemDB
import com.example.shopapp.features.productDetailsScreen.data.modelRemote.ProductDetailsItemRemote
import com.example.shopapp.features.productDetailsScreen.data.network.ShopDetailsApiService


class PDLocalDataSourceImpl(private val pdCacheDao: PDCacheDao) :
    PDLocalDataSource {

    override suspend fun insertPDItemToCache(productDetailsItemDB: ProductDetailsItemDB) {
        pdCacheDao.insertProductDetails(productDetailsItemDB)
    }

    override suspend fun getProductDetails(): List<ProductDetailsItemDB> {
        return pdCacheDao.getProductDetails()
    }


}