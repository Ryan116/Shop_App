package com.example.shopapp.features.productDetailsScreen.data.cacheDB.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shopapp.common.constants.Constants.PRODUCT_DETAILS_DATABASE_TABLE_NAME
import com.example.shopapp.common.constants.Constants.PRODUCT_DETAILS_DATABASE_VERSION
import com.example.shopapp.features.productDetailsScreen.data.cacheDB.modelDB.ProductDetailsItemDB

@Database(entities = [ProductDetailsItemDB::class], version = PRODUCT_DETAILS_DATABASE_VERSION, exportSchema = false)
@TypeConverters(PDItemTypeConverters::class)
abstract class ProductDetailsDatabase : RoomDatabase() {

    abstract fun productDetailsDao(): ProductDetailsDao

    companion object {
        @Volatile
        private var INSTANCE: ProductDetailsDatabase? = null
        fun getDatabase(application: Application): ProductDetailsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    ProductDetailsDatabase::class.java,
                    PRODUCT_DETAILS_DATABASE_TABLE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}