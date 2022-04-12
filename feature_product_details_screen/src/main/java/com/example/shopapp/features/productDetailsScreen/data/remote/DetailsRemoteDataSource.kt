package com.example.shopapp.features.productDetailsScreen.data.remote

import com.example.shopapp.features.productDetailsScreen.data.modelDB.ProductDetailsItemDB


interface DetailsRemoteDataSource {

    suspend fun getPhonesDetailsList() : ProductDetailsItemDB

}