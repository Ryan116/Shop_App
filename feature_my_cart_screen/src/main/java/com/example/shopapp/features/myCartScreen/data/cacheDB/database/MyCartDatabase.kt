package com.example.shopapp.features.myCartScreen.data.cacheDB.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shopapp.features.myCartScreen.data.cacheDB.modelDB.BasketMainDB

@Database(entities = [ BasketMainDB::class ], version = 1, exportSchema = false)
@TypeConverters(MyCartTypeConverters::class)
abstract class MyCartDatabase : RoomDatabase() {

    abstract fun myCartDao(): MyCartDao

    companion object {
        @Volatile
        private var INSTANCE: MyCartDatabase? = null
        fun getDatabase(application: Application): MyCartDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    MyCartDatabase::class.java,
                    "my_cart_cache"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}