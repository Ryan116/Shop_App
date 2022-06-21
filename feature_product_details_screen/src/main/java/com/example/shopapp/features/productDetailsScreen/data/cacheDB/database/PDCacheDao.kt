package com.example.shopapp.features.productDetailsScreen.data.cacheDB.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shopapp.features.productDetailsScreen.data.cacheDB.modelDB.ProductDetailsItemDB

@Dao
interface PDCacheDao {
    @Query("SELECT * FROM product_details_cache ORDER BY id")
    suspend fun getProductDetails(): List<ProductDetailsItemDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductDetails(productDetailsItemDB: ProductDetailsItemDB)

}