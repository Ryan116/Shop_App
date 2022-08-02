package com.example.shopapp.features.bookmarksScreen.data.dataSource.local

import androidx.lifecycle.LiveData
import com.example.shopapp.common.database.data.database.BookmarkDao
import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB


class BookmarkLocalDataSourceImpl(private val bookmarkDao: BookmarkDao) : BookmarkLocalDataSource {
    override suspend fun getBookmarks(): LiveData<List<PhoneBookmarkDB>> {
        return bookmarkDao.getBookmarks()
    }

    override suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB) {
        bookmarkDao.deleteBookmark(phoneBookmarkDB)
    }

    override suspend fun deleteAllBookmarks() {
        bookmarkDao.deleteAllBookmarks()
    }


}