package com.example.shopapp.features.mainScreen.data.source.local

import com.example.shopapp.common.bookmarkDatabase.data.modelDB.BookmarkDB


interface LocalDataSource {
    suspend fun addBookmark(bookmarkDB: BookmarkDB)

    suspend fun deleteBookmark(bookmarkDB: BookmarkDB)

}