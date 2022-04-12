package com.example.shopapp.features.mainScreen.data.modelDB

import com.squareup.moshi.Json

data class MainDB(
    @Json(name = "home_store") val homeStore: List<HomeStoreDB>,
    @Json(name = "best_seller") val bestSeller: List<BestSellerDB>
    )