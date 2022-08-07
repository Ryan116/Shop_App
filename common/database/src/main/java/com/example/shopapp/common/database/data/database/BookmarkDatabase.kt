package com.example.shopapp.common.database.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shopapp.common.constants.Constants.BOOKMARK_DATABASE_NAME
import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB

@Database(entities = [PhoneBookmarkDB::class], version = 1, exportSchema = false)
abstract class BookmarkDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao

    companion object {
        @Volatile
        private var INSTANCE: BookmarkDatabase? = null
        fun getDatabase(application: Application): BookmarkDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    BookmarkDatabase::class.java,
                    BOOKMARK_DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}