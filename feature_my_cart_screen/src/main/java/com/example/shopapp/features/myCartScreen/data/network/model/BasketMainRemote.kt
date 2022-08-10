package com.example.shopapp.features.myCartScreen.data.network.model

data class BasketMainRemote(
    val id: String,
    val basket: List<BasketProductRemote>,
    val delivery: String,
    val total: Int
)