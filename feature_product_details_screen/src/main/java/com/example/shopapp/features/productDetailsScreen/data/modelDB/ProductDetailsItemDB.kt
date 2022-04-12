package com.example.shopapp.features.productDetailsScreen.data.modelDB

import com.squareup.moshi.Json

data class ProductDetailsItemDB(
    @Json(name = "CPU") val cpu: String,
    val id: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String
)