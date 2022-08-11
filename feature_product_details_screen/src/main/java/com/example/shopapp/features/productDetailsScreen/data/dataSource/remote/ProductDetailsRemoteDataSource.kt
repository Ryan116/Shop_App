package com.example.shopapp.features.productDetailsScreen.data.dataSource.remote

import com.example.shopapp.features.productDetailsScreen.data.network.model.ProductDetailsItemRemote


interface ProductDetailsRemoteDataSource {

    suspend fun getPhonesDetailsList(): ProductDetailsItemRemote
}