package com.example.shopapp.common.bookmarkDatabase.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shopapp.common.bookmarkDatabase.data.modelDB.BookmarkDB

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM phone_table ORDER BY id")
    fun getBookmarks(): LiveData<List<BookmarkDB>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBookmark(bookmarkDB: BookmarkDB)

    @Delete
    suspend fun deleteBookmark(bookmarkDB: BookmarkDB)

    @Query("DELETE FROM phone_table")
    suspend fun deleteAllBookmarks()

}