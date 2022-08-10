package com.example.shopapp.features.myCartScreen.data.network

import com.example.shopapp.common.constants.Constants.MY_CART_BASE_URL
import com.example.shopapp.common.constants.Constants.MY_CART_GET
import com.example.shopapp.features.myCartScreen.data.network.model.BasketMainRemote
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(MY_CART_BASE_URL)
    .build()

interface MyCartApiService {
    @GET(MY_CART_GET)
    suspend fun getMyCart(): BasketMainRemote
}

object MyCartApi {
    val retrofitService: MyCartApiService by lazy {
        retrofit.create(MyCartApiService::class.java)
    }
}