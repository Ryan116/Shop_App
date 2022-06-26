package com.example.shopapp.features.mainScreen.data.dataSource.local

import com.example.shopapp.common.database.data.database.BookmarkDao
import com.example.shopapp.common.database.data.modelDB.BookmarkDB
import com.example.shopapp.features.mainScreen.data.cacheDB.database.MainScreenDao
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.BestSellerDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.HomeStoreDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.MainDB


class LocalDataSourceImpl(
    private val bookmarkDao: BookmarkDao,
    private val mainScreenDao: MainScreenDao
) : LocalDataSource {

    override suspend fun addBookmark(bookmarkDB: BookmarkDB) {
        bookmarkDao.addBookmark(bookmarkDB)
    }

    override suspend fun deleteBookmark(bookmarkDB: BookmarkDB) {
        bookmarkDao.deleteBookmark(bookmarkDB)
    }

    override suspend fun insertMainDBToDB(mainDB: MainDB) {
        mainScreenDao.insertMainDB(mainDB)
    }

    override suspend fun getLIstMainDB(): List<MainDB> {
        return mainScreenDao.getListMainDB()
    }

    override suspend fun getBestSellerDBPhonesList(): List<BestSellerDB> {
        return mainScreenDao.getListMainDB()[0].bestSeller
    }

    override suspend fun getHomeStoreDBPhonesList(): List<HomeStoreDB> {
        return mainScreenDao.getListMainDB()[0].homeStore
    }


}