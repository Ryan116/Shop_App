package com.example.shopapp.features.myCartScreen.data.cacheDB.modelDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_cart_cache")
data class BasketMainDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val basket: List<BasketProductDB>,
    val delivery: String,
    val total: Int
)