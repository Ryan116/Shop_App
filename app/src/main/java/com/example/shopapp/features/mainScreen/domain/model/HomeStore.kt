package com.example.shopapp.features.mainScreen.domain.model

import com.squareup.moshi.Json

data class HomeStore(
    val id: Int,
    val title: String,
    val subtitle: String,
    val picture: String,
    @Json(name = "is_buy") val isBuy: Boolean
    )
