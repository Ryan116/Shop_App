package com.example.shopapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.shopapp.domain.model.PhoneBookmark
import com.example.shopapp.domain.repository.AppRepository

class GetBookmarksListUseCase(private val appRepository: AppRepository) {

    fun getBookmarksList(): LiveData<List<PhoneBookmark>> {
        return appRepository.getBookmarks()
    }
}

