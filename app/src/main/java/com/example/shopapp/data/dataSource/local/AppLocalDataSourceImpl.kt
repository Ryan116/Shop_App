package com.example.shopapp.data.dataSource.local

import androidx.lifecycle.LiveData
import com.example.shopapp.common.database.data.database.BookmarkDao
import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB

class AppLocalDataSourceImpl(private val bookmarkDao: BookmarkDao) : AppLocalDataSource {

    override fun getBookmarks(): LiveData<List<PhoneBookmarkDB>> {
        return bookmarkDao.getBookmarks()
    }
}