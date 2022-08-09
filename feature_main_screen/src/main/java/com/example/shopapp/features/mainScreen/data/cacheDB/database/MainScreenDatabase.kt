package com.example.shopapp.features.mainScreen.data.cacheDB.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shopapp.common.constants.Constants.MAIN_SCREEN_DATABASE_NAME
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.MainDB

@Database(entities = [MainDB::class], version = 1, exportSchema = false)
@TypeConverters(MainScreenTypeConverters::class)
abstract class MainScreenDatabase : RoomDatabase() {

    abstract fun mainScreenDao(): MainScreenDao

    companion object {
        @Volatile
        private var INSTANCE: MainScreenDatabase? = null
        fun getDatabase(application: Application): MainScreenDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    MainScreenDatabase::class.java,
                    MAIN_SCREEN_DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}