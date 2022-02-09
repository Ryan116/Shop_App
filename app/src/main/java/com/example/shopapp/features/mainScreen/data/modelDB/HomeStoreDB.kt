package com.example.shopapp.features.mainScreen.data.modelDB

import com.squareup.moshi.Json

data class HomeStoreDB(
    val id: Int,
    val title: String,
    val subtitle: String,
    val picture: String,
    @Json(name = "is_buy") val isBuy: Boolean,
)