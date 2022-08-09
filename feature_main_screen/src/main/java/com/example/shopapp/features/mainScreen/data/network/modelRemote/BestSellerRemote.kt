package com.example.shopapp.features.mainScreen.data.network.modelRemote

import com.example.shopapp.common.constants.Constants.BESTSELLER_REMOTE_DISCOUNT_PRICE
import com.example.shopapp.common.constants.Constants.BESTSELLER_REMOTE_IS_FAVORITES_NAME
import com.example.shopapp.common.constants.Constants.BESTSELLER_REMOTE_PRICE_WITHOUT_DISCOUNT
import com.squareup.moshi.Json

data class BestSellerRemote(
    val id: Int,
    @Json(name = BESTSELLER_REMOTE_IS_FAVORITES_NAME) val isFavorites: Boolean,
    val title: String,
    @Json(name = BESTSELLER_REMOTE_PRICE_WITHOUT_DISCOUNT) val priceWithoutDiscount: Int,
    @Json(name = BESTSELLER_REMOTE_DISCOUNT_PRICE) val discountPrice: Int,
    val picture: String
)

