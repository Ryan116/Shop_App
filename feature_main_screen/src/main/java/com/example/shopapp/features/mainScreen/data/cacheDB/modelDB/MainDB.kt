package com.example.shopapp.features.mainScreen.data.cacheDB.modelDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main_screen_cache")
data class MainDB(
    val homeStore: List<HomeStoreDB>,
    val bestSeller: List<BestSellerDB>
    ) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}