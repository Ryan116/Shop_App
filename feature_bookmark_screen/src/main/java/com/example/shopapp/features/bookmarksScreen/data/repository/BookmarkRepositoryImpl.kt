package com.example.shopapp.features.bookmarksScreen.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shopapp.features.bookmarksScreen.data.dataSource.local.LocalDataSource
import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark
import com.example.shopapp.features.bookmarksScreen.domain.repository.BookmarkRepository
import com.example.shopapp.features.bookmarksScreen.data.mapper.BookmarkScreenMapper

class BookmarkRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val bookmarkScreenMapper: BookmarkScreenMapper
) : BookmarkRepository {

    override suspend fun getBookmarks(): LiveData<List<Bookmark>> {
        val liveDataListBookmark = Transformations.map(localDataSource.getBookmarks()) {
            bookmarkScreenMapper.mapListBookmarkDBToBookmark(it)
        }
        return liveDataListBookmark
    }

    override suspend fun deleteBookmark(bookmark: Bookmark) {
        localDataSource.deleteBookmark(bookmarkScreenMapper.mapBookmarkToBookmarkDB(bookmark))
    }

    override suspend fun deleteAllBookmarks() {
        localDataSource.deleteAllBookmarks()
    }


}