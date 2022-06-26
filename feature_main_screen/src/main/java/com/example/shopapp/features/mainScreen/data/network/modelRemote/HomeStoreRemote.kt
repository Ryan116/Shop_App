package com.example.shopapp.features.mainScreen.data.network.modelRemote

import com.squareup.moshi.Json

data class HomeStoreRemote(
    val id: Int,
    val title: String,
    val subtitle: String,
    val picture: String,
    @Json(name = "is_buy") val isBuy: Boolean,
)