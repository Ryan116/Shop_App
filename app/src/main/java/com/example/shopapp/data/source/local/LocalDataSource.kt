package com.example.shopapp.data.source.local

import androidx.lifecycle.LiveData
import com.example.shopapp.common.bookmarkDatabase.data.modelDB.BookmarkDB


interface LocalDataSource {
    suspend fun getBookmarks(): LiveData<List<BookmarkDB>>

}