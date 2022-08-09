package com.example.shopapp.features.mainScreen.data.network.modelRemote

import com.example.shopapp.common.constants.Constants.HOME_STORE_REMOTE_IS_BUY_NAME
import com.squareup.moshi.Json

data class HomeStoreRemote(
    val id: Int,
    val title: String,
    val subtitle: String,
    val picture: String,
    @Json(name = HOME_STORE_REMOTE_IS_BUY_NAME) val isBuy: Boolean,
)