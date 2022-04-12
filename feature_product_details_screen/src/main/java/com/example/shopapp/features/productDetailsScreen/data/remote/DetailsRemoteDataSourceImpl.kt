package com.example.shopapp.features.productDetailsScreen.data.remote

import com.example.shopapp.features.productDetailsScreen.data.modelDB.ProductDetailsItemDB
import com.example.shopapp.features.productDetailsScreen.data.network.ShopDetailsApiService


class DetailsRemoteDataSourceImpl(private val detailsApiService: ShopDetailsApiService) :
    DetailsRemoteDataSource {
    override suspend fun getPhonesDetailsList(): ProductDetailsItemDB {
        return detailsApiService.getProductDetails()
    }


}