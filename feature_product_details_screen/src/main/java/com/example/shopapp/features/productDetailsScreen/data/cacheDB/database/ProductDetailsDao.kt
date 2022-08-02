package com.example.shopapp.features.productDetailsScreen.data.cacheDB.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shopapp.features.productDetailsScreen.data.cacheDB.modelDB.ProductDetailsItemDB

@Dao
interface ProductDetailsDao {
    @Query("SELECT * FROM product_details_cache ORDER BY id")
    suspend fun getProductDetails(): List<ProductDetailsItemDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductDetails(productDetailsItemDB: ProductDetailsItemDB)

}