package com.example.shopapp.features.productDetailsScreen.data.dataSource.remote

import com.example.shopapp.features.productDetailsScreen.data.network.modelRemote.ProductDetailsItemRemote
import com.example.shopapp.features.productDetailsScreen.data.network.ProductDetailsApiService

class ProductDetailsRemoteDataSourceImpl(private val productDetailsApiService: ProductDetailsApiService) :
    ProductDetailsRemoteDataSource {

    override suspend fun getPhonesDetailsList(): ProductDetailsItemRemote {
        return productDetailsApiService.getProductDetails()
    }
}