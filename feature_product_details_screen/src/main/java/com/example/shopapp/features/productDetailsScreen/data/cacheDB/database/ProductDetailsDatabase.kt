package com.example.shopapp.features.productDetailsScreen.data.cacheDB.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shopapp.features.productDetailsScreen.data.cacheDB.modelDB.ProductDetailsItemDB

@Database(entities = [ ProductDetailsItemDB::class ], version=1, exportSchema = false)
@TypeConverters(PDItemTypeConverters::class)
abstract class ProductDetailsDatabase : RoomDatabase() {

    abstract fun productDetailsDao(): PDCacheDao

    companion object {
        @Volatile
        private var INSTANCE: ProductDetailsDatabase? = null
        fun getDatabase(application: Application): ProductDetailsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    ProductDetailsDatabase::class.java,
                    "product_details_cache"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}