package com.example.shopapp.common.database.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM phone_table ORDER BY id")
    fun getBookmarks(): LiveData<List<PhoneBookmarkDB>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    @Delete
    suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    @Query("DELETE FROM phone_table")
    suspend fun deleteAllBookmarks()
}