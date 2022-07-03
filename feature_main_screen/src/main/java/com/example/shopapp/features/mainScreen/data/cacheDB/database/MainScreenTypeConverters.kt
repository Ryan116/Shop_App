package com.example.shopapp.features.mainScreen.data.cacheDB.database

import androidx.room.TypeConverter
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.BestSellerDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.HomeStoreDB
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.ParameterizedType

class MainScreenTypeConverters {

    private val moshiBestSellerDB = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val listBestSellerDB : ParameterizedType = Types.newParameterizedType(List::class.java, BestSellerDB::class.java)
    private val jsonAdapterBestSellerDB: JsonAdapter<List<BestSellerDB>> = moshiBestSellerDB.adapter(listBestSellerDB)

    private val moshiHomeStoreDB = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val listHomeStoreDB : ParameterizedType = Types.newParameterizedType(List::class.java, HomeStoreDB::class.java)
    private val jsonAdapterHomeStoreDB: JsonAdapter<List<HomeStoreDB>> = moshiHomeStoreDB.adapter(listHomeStoreDB)

    @TypeConverter
    fun listBestSellerDBlToJsonStr(listMyModel: List<BestSellerDB>?): String? {
        return jsonAdapterBestSellerDB.toJson(listMyModel)
    }

    @TypeConverter
    fun jsonStrToListBestSellerDB(jsonStr: String?): List<BestSellerDB>? {
        return jsonStr?.let { jsonAdapterBestSellerDB.fromJson(jsonStr) }
    }

    @TypeConverter
    fun listHomeStoreDBToJsonStr(listMyModel: List<HomeStoreDB>?): String? {
        return jsonAdapterHomeStoreDB.toJson(listMyModel)
    }

    @TypeConverter
    fun jsonStrToListHomeStoreDB(jsonStr: String?): List<HomeStoreDB>? {
        return jsonStr?.let { jsonAdapterHomeStoreDB.fromJson(jsonStr) }
    }
}