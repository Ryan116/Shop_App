package com.example.shopapp.features.bookmarksScreen.domain.usecase

import androidx.lifecycle.LiveData
import com.example.shopapp.features.bookmarksScreen.domain.model.PhoneBookmark
import com.example.shopapp.features.bookmarksScreen.domain.repository.BookmarkRepository

class GetBookmarksListUseCase(private val bookmarkRepository: BookmarkRepository) {

    fun getBookmarksList(): LiveData<List<PhoneBookmark>> {
        return bookmarkRepository.getBookmarks()
    }
}

