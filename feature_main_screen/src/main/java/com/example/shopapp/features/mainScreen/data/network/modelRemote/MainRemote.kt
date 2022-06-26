package com.example.shopapp.features.mainScreen.data.network.modelRemote

import com.squareup.moshi.Json

data class MainRemote(
    @Json(name = "home_store") val homeStore: List<HomeStoreRemote>,
    @Json(name = "best_seller") val bestSeller: List<BestSellerRemote>
    )