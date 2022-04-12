package com.example.shopapp.features.myCartScreen.data.network

import com.example.shopapp.features.myCartScreen.data.modelDB.BasketMainDB
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

interface MyCartApiService {
    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getMyCart(): BasketMainDB
}

object MyCartApi {
    val retrofitService : MyCartApiService by lazy {
        retrofit.create(MyCartApiService::class.java) }
}