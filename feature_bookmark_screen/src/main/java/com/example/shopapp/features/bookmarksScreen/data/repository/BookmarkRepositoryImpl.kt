package com.example.shopapp.features.bookmarksScreen.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shopapp.features.bookmarksScreen.data.dataSource.local.BookmarkLocalDataSource
import com.example.shopapp.features.bookmarksScreen.data.mapper.BookmarkMapper
import com.example.shopapp.features.bookmarksScreen.domain.model.PhoneBookmark
import com.example.shopapp.features.bookmarksScreen.domain.repository.BookmarkRepository

class BookmarkRepositoryImpl(
    private val bookmarkLocalDataSource: BookmarkLocalDataSource,
    private val bookmarkMapper: BookmarkMapper
) : BookmarkRepository {

    override fun getBookmarks(): LiveData<List<PhoneBookmark>> =
        Transformations.map(bookmarkLocalDataSource.getBookmarks()) {
            bookmarkMapper.mapListBookmarkDBToListBookmark(it)
        }

    override suspend fun deleteBookmark(phoneBookmark: PhoneBookmark) {
        bookmarkLocalDataSource.deleteBookmark(
            bookmarkMapper.mapBookmarkToPhoneBookmarkDB(
                phoneBookmark
            )
        )
    }

    override suspend fun deleteAllBookmarks() {
        bookmarkLocalDataSource.deleteAllBookmarks()
    }
}