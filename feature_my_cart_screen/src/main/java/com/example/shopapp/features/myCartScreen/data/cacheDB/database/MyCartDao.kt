package com.example.shopapp.features.myCartScreen.data.cacheDB.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shopapp.features.myCartScreen.data.cacheDB.modelDB.BasketMainDB

@Dao
interface MyCartDao {

    @Query("SELECT * FROM my_cart_cache ORDER BY id")
    suspend fun getMyCart(): List<BasketMainDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyCart(basketMainDB: BasketMainDB)

}