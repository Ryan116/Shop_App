package com.example.shopapp.data.source.local

import androidx.lifecycle.LiveData
import com.example.shopapp.common.database.data.modelDB.BookmarkDB


interface LocalDataSource {
    suspend fun getBookmarks(): LiveData<List<BookmarkDB>>

}