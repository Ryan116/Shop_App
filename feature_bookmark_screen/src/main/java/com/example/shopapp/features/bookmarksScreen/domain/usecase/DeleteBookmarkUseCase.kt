package com.example.shopapp.features.bookmarksScreen.domain.usecase

import com.example.shopapp.features.bookmarksScreen.domain.model.PhoneBookmark
import com.example.shopapp.features.bookmarksScreen.domain.repository.BookmarkRepository

class DeleteBookmarkUseCase(private val bookmarkRepository: BookmarkRepository) {

    suspend fun deleteBookmark(phoneBookmark: PhoneBookmark) {
        bookmarkRepository.deleteBookmark(phoneBookmark)
    }
}
