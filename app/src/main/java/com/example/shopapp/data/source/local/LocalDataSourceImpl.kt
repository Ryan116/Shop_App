package com.example.shopapp.data.source.local

import androidx.lifecycle.LiveData
import com.example.shopapp.common.database.data.database.BookmarkDao
import com.example.shopapp.common.database.data.modelDB.BookmarkDB


class LocalDataSourceImpl(private val bookmarkDao: BookmarkDao) : LocalDataSource {
    override suspend fun getBookmarks(): LiveData<List<BookmarkDB>> {
        return bookmarkDao.getBookmarks()
    }


}