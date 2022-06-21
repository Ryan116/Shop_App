package com.example.shopapp.features.productDetailsScreen.data.dataSource.remote

import com.example.shopapp.features.productDetailsScreen.data.modelRemote.ProductDetailsItemRemote


interface PDRemoteDataSource {

    suspend fun getPhonesDetailsList() : ProductDetailsItemRemote

}