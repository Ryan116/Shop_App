package com.example.shopapp.features.bookmarksScreen.data.dataSource.local

import androidx.lifecycle.LiveData
import com.example.shopapp.common.bookmarkDatabase.data.modelDB.BookmarkDB


interface LocalDataSource {
    suspend fun getBookmarks(): LiveData<List<BookmarkDB>>

    suspend fun deleteBookmark(bookmarkDB: BookmarkDB)

    suspend fun deleteAllBookmarks()

}