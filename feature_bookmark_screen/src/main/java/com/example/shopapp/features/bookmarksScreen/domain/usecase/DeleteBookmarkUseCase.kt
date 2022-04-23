package com.example.shopapp.features.bookmarksScreen.domain.usecase


import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark
import com.example.shopapp.features.bookmarksScreen.domain.repository.BookmarkRepository

class DeleteBookmarkUseCase(private val bookmarkRepository: BookmarkRepository) {
    suspend fun deleteBookmark(bookmark: Bookmark) {
        bookmarkRepository.deleteBookmark(bookmark)
    }
}
