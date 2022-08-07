package com.example.shopapp.features.bookmarksScreen.data.dataSource.local

import androidx.lifecycle.LiveData
import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB

interface BookmarkLocalDataSource {

    fun getBookmarks(): LiveData<List<PhoneBookmarkDB>>

    suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    suspend fun deleteAllBookmarks()
}