package com.example.shopapp.features.bookmarksScreen.domain.usecase


import com.example.shopapp.features.bookmarksScreen.domain.repository.BookmarkRepository

class DeleteAllBookmarksUseCase(private val bookmarkRepository: BookmarkRepository) {
    suspend fun deleteAllBookmarks() {
        bookmarkRepository.deleteAllBookmarks()
    }
}