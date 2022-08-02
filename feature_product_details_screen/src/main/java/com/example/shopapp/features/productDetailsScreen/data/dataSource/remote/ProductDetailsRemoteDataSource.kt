package com.example.shopapp.features.productDetailsScreen.data.dataSource.remote

import com.example.shopapp.features.productDetailsScreen.data.network.modelRemote.ProductDetailsItemRemote


interface ProductDetailsRemoteDataSource {

    suspend fun getPhonesDetailsList() : ProductDetailsItemRemote

}