package com.example.shopapp.features.productDetailsScreen.data.dataSource.remote

import com.example.shopapp.features.productDetailsScreen.data.network.ProductDetailsApiService
import com.example.shopapp.features.productDetailsScreen.data.network.model.ProductDetailsItemRemote

class ProductDetailsRemoteDataSourceImpl(private val productDetailsApiService: ProductDetailsApiService) :
    ProductDetailsRemoteDataSource {

    override suspend fun getPhonesDetailsList(): ProductDetailsItemRemote {
        return productDetailsApiService.getProductDetails()
    }
}