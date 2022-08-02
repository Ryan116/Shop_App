package com.example.shopapp.features.mainScreen.data.network

import com.example.shopapp.features.mainScreen.data.network.modelRemote.MainRemote
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://run.mocky.io/v3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MainApiService {


    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getMain(): MainRemote
}

object MainApi {
    val retrofitService : MainApiService by lazy {
        retrofit.create(MainApiService::class.java) }
}