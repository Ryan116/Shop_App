package com.example.shopapp.features.bookmarksScreen.domain.usecase

import androidx.lifecycle.LiveData
import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark
import com.example.shopapp.features.bookmarksScreen.domain.repository.BookmarkRepository

class GetBookmarksListUseCase(private val bookmarkRepository: BookmarkRepository) {
    suspend fun getBookmarksList(): LiveData<List<Bookmark>> {
        return bookmarkRepository.getBookmarks()
    }
}

