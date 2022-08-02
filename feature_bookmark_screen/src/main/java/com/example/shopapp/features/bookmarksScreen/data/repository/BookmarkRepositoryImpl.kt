package com.example.shopapp.features.bookmarksScreen.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shopapp.features.bookmarksScreen.data.dataSource.local.BookmarkLocalDataSource
import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark
import com.example.shopapp.features.bookmarksScreen.domain.repository.BookmarkRepository
import com.example.shopapp.features.bookmarksScreen.data.mapper.BookmarkMapper

class BookmarkRepositoryImpl(
    private val bookmarkLocalDataSource: BookmarkLocalDataSource,
    private val bookmarkMapper: BookmarkMapper
) : BookmarkRepository {

    override suspend fun getBookmarks(): LiveData<List<Bookmark>> {
        val liveDataListBookmark = Transformations.map(bookmarkLocalDataSource.getBookmarks()) {
            bookmarkMapper.mapListBookmarkDBToBookmark(it)
        }
        return liveDataListBookmark
    }

    override suspend fun deleteBookmark(bookmark: Bookmark) {
        bookmarkLocalDataSource.deleteBookmark(bookmarkMapper.mapBookmarkToBookmarkDB(bookmark))
    }

    override suspend fun deleteAllBookmarks() {
        bookmarkLocalDataSource.deleteAllBookmarks()
    }


}