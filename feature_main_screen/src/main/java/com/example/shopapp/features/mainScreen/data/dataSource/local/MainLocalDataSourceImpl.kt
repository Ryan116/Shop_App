package com.example.shopapp.features.mainScreen.data.dataSource.local

import com.example.shopapp.common.database.data.database.BookmarkDao
import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB
import com.example.shopapp.features.mainScreen.data.cacheDB.database.MainScreenDao
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.BestSellerDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.HomeStoreDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.MainDB


class MainLocalDataSourceImpl(
    private val bookmarkDao: BookmarkDao,
    private val mainScreenDao: MainScreenDao
) : MainLocalDataSource {

    override suspend fun addBookmark(phoneBookmarkDB: PhoneBookmarkDB) {
        bookmarkDao.addBookmark(phoneBookmarkDB)
    }

    override suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB) {
        bookmarkDao.deleteBookmark(phoneBookmarkDB)
    }

    override suspend fun insertMainDBToDB(mainDB: MainDB) {
        mainScreenDao.insertMainDB(mainDB)
    }

    override suspend fun getBestSellerDBPhonesList(): List<BestSellerDB> {
        return mainScreenDao.getListMainDB()[0].bestSeller
    }

    override suspend fun getHomeStoreDBPhonesList(): List<HomeStoreDB> {
        return mainScreenDao.getListMainDB()[0].homeStore
    }


}