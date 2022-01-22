package com.example.shopapp.features.mainScreen.domain.model

import com.squareup.moshi.Json

data class Main(
    @Json(name = "_id") val id: String,
    @Json(name = "home_store") val homeStore: List<HomeStore>,
    @Json(name = "best_seller") val bestSeller: List<BestSeller>
    )