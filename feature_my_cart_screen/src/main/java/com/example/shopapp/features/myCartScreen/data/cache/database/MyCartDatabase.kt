package com.example.shopapp.features.myCartScreen.data.cache.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shopapp.common.constants.Constants.MY_CART_DATABASE_TABLE_NAME
import com.example.shopapp.common.constants.Constants.MY_CART_DATABASE_VERSION
import com.example.shopapp.features.myCartScreen.data.cache.model.BasketMainDB

@Database(
    entities = [BasketMainDB::class],
    version = MY_CART_DATABASE_VERSION,
    exportSchema = false
)
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
                    MY_CART_DATABASE_TABLE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}