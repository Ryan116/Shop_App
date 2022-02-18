package com.example.shopapp.features.myCartScreen.domain.model

data class BasketMain(
    val _id: String,
    val basket: List<BasketProduct>,
    val delivery: String,
    val total: Int
)