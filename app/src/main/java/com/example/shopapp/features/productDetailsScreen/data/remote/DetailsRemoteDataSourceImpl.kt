package com.example.shopapp.features.productDetailsScreen.data.remote

import com.example.shopapp.features.productDetailsScreen.data.network.ShopDetailsApiService
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem


class DetailsRemoteDataSourceImpl(private val detailsApiService: ShopDetailsApiService) : DetailsRemoteDataSource {
    override suspend fun getPhonesDetailsList(): List<ProductDetailsItem> {
        return detailsApiService.getProductDetails()
    }


}