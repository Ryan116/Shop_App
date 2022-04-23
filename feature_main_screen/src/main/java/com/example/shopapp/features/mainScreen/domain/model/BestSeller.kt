package com.example.shopapp.features.mainScreen.domain.model



data class BestSeller(
    val id: Int,
    val isFavorites: Boolean,
    val title: String,
    val priceWithoutDiscount: Int,
    val discountPrice: Int,
    val picture: String
)

