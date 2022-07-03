package com.example.shopapp.features.myCartScreen.data.cacheDB.database

import androidx.room.TypeConverter
import com.example.shopapp.features.myCartScreen.data.cacheDB.modelDB.BasketProductDB
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.ParameterizedType

class MyCartTypeConverters {

    private val moshi =
        Moshi.Builder().add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory()).build()
    private val listMyData: ParameterizedType =
        Types.newParameterizedType(List::class.java, BasketProductDB::class.java)
    private val jsonAdapter: JsonAdapter<List<BasketProductDB>> = moshi.adapter(listMyData)

    @TypeConverter
    fun listMyModelToJsonStr(listMyModel: List<BasketProductDB>?): String? {
        return jsonAdapter.toJson(listMyModel)
    }

    @TypeConverter
    fun jsonStrToListMyModel(jsonStr: String?): List<BasketProductDB>? {
        return jsonStr?.let { jsonAdapter.fromJson(jsonStr) }
    }
}