package com.example.shopapp.features.mainScreen.domain.model

import com.squareup.moshi.Json

data class BestSeller(
    val id: Int,
    @Json(name = "is_favorites") val isFavorites: Boolean,
    val title: String,
    @Json(name = "price_without_discount") val priceWithoutDiscount: Int,
    @Json(name = "discount_price") val discountPrice: Int,
    val picture: String
)

