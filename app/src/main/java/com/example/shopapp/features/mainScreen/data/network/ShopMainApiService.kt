package com.example.shopapp.features.mainScreen.data.network

import com.example.shopapp.features.mainScreen.domain.model.Main
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL =
    "https://shopapi-0575.restdb.io/rest/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ShopMainApiService {

    @Headers(
        "x-apikey: 61ddae2e95cb716ea5ee48e4"
    )
    @GET("home")
    suspend fun getMain(): List<Main>
}

object ShopMainApi {
    val retrofitService : ShopMainApiService by lazy {
        retrofit.create(ShopMainApiService::class.java) }
}