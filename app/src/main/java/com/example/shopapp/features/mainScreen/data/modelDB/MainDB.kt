package com.example.shopapp.features.mainScreen.data.modelDB

import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.squareup.moshi.Json

data class MainDB(
    @Json(name = "_id") val id: String,
    @Json(name = "home_store") val homeStore: List<HomeStore>,
    @Json(name = "best_seller") val bestSeller: List<BestSeller>
    )