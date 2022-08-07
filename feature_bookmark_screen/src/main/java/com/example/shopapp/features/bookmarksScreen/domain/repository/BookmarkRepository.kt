package com.example.shopapp.features.bookmarksScreen.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopapp.features.bookmarksScreen.domain.model.PhoneBookmark

interface BookmarkRepository {

    fun getBookmarks(): LiveData<List<PhoneBookmark>>

    suspend fun deleteBookmark(phoneBookmark: PhoneBookmark)

    suspend fun deleteAllBookmarks()
}

