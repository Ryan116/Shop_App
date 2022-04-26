package com.example.shopapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.shopapp.domain.model.Bookmark
import com.example.shopapp.domain.repository.AppRepository

class GetBookmarksListUseCase(private val appRepository: AppRepository) {
    suspend fun getBookmarksList(): LiveData<List<Bookmark>> {
        return appRepository.getBookmarks()
    }
}

