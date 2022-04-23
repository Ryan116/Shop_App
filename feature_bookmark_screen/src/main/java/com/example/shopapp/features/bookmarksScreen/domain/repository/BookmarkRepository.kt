package com.example.shopapp.features.bookmarksScreen.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark

interface BookmarkRepository {
    suspend fun getBookmarks(): LiveData<List<Bookmark>>

    suspend fun deleteBookmark(bookmark: Bookmark)

    suspend fun deleteAllBookmarks()
}

