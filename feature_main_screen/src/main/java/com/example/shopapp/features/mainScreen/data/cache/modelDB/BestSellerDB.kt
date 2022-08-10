package com.example.shopapp.features.mainScreen.data.cacheDB.modelDB

data class BestSellerDB(
    val id: Int,
    val isFavorites: Boolean,
    val title: String,
    val priceWithoutDiscount: Int,
    val discountPrice: Int,
    val picture: String
)

