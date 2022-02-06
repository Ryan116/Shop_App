package com.example.shopapp.features.productDetailsScreen.data.remote

import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem


interface DetailsRemoteDataSource {

    suspend fun getPhonesDetailsList() : List<ProductDetailsItem>

}