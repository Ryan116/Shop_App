package com.example.shopapp.features.productDetailsScreen.domain.model

data class ProductDetailsItem(
    val cpu: String,
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