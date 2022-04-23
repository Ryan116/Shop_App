package com.example.shopapp.features.bookmarksScreen.data.dataSource.local

import androidx.lifecycle.LiveData
import com.example.shopapp.common.bookmarkDatabase.data.database.BookmarkDao
import com.example.shopapp.common.bookmarkDatabase.data.modelDB.BookmarkDB


class LocalDataSourceImpl(private val bookmarkDao: BookmarkDao) : LocalDataSource {
    override suspend fun getBookmarks(): LiveData<List<BookmarkDB>> {
        return bookmarkDao.getBookmarks()
    }

    override suspend fun deleteBookmark(bookmarkDB: BookmarkDB) {
        bookmarkDao.deleteBookmark(bookmarkDB)
    }

    override suspend fun deleteAllBookmarks() {
        bookmarkDao.deleteAllBookmarks()
    }


}