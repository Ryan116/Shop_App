package com.example.shopapp.features.mainScreen.data.dataSource.local

import com.example.shopapp.common.database.data.modelDB.BookmarkDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.BestSellerDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.HomeStoreDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.MainDB
import com.example.shopapp.features.mainScreen.data.network.modelRemote.BestSellerRemote
import com.example.shopapp.features.mainScreen.data.network.modelRemote.HomeStoreRemote


interface LocalDataSource {
    suspend fun addBookmark(bookmarkDB: BookmarkDB)

    suspend fun deleteBookmark(bookmarkDB: BookmarkDB)

    suspend fun insertMainDBToDB(mainDB: MainDB)

    suspend fun getLIstMainDB(): List<MainDB>

    suspend fun getBestSellerDBPhonesList(): List<BestSellerDB>

    suspend fun getHomeStoreDBPhonesList(): List<HomeStoreDB>

}