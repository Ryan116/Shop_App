package com.example.shopapp.features.mainScreen.data.network

import com.example.shopapp.common.constants.Constants.MAIN_API_BASE_URL
import com.example.shopapp.common.constants.Constants.MAIN_API_GET
import com.example.shopapp.features.mainScreen.data.network.modelRemote.MainRemote
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
    .baseUrl(MAIN_API_BASE_URL)
    .build()

interface MainApiService {
    @GET(MAIN_API_GET)
    suspend fun getMain(): MainRemote
}

object MainApi {
    val retrofitService: MainApiService by lazy {
        retrofit.create(MainApiService::class.java)
    }
}