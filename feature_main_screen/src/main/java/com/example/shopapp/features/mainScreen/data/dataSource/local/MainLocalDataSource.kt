package com.example.shopapp.features.mainScreen.data.dataSource.local

import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.BestSellerDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.HomeStoreDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.MainDB

interface MainLocalDataSource {

    suspend fun addBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    suspend fun insertMainDBToDB(mainDB: MainDB)

    suspend fun getBestSellerDBPhonesList(): List<BestSellerDB>

    suspend fun getHomeStoreDBPhonesList(): List<HomeStoreDB>
}