package com.example.shopapp.features.productDetailsScreen.domain.model

import com.squareup.moshi.Json

data class ProductDetailsItem(
    @Json(name = "CPU") val cpu: String,
    @Json(name = "_id") val id: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Int,
    val sd: String,
    val ssd: String,
    val title: String
)