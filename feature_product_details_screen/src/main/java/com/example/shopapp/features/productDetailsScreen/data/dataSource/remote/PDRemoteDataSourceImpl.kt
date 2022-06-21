package com.example.shopapp.features.productDetailsScreen.data.dataSource.remote

import com.example.shopapp.features.productDetailsScreen.data.modelRemote.ProductDetailsItemRemote
import com.example.shopapp.features.productDetailsScreen.data.network.ShopDetailsApiService


class PDRemoteDataSourceImpl(private val detailsApiService: ShopDetailsApiService) :
    PDRemoteDataSource {
    override suspend fun getPhonesDetailsList(): ProductDetailsItemRemote {
        return detailsApiService.getProductDetails()
    }


}