package com.example.shopapp.features.productDetailsScreen.data.network

import com.example.shopapp.features.productDetailsScreen.data.modelDB.ProductDetailsItemDB
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL =
    "https://run.mocky.io/v3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ShopDetailsApiService {
    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getProductDetails(): ProductDetailsItemDB
}

object ShopDetailsApi {
    val retrofitService : ShopDetailsApiService by lazy {
        retrofit.create(ShopDetailsApiService::class.java) }
}