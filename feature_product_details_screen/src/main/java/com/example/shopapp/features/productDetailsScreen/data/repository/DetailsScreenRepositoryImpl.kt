package com.example.shopapp.features.productDetailsScreen.data.repository

import com.example.shopapp.features.productDetailsScreen.data.mapper.ProductDetailsScreenMapper
import com.example.shopapp.features.productDetailsScreen.data.remote.DetailsRemoteDataSource
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository

class DetailsScreenRepositoryImpl(
    private val detailsRemoteDataSource: DetailsRemoteDataSource,
    private val productDetailsMapper: ProductDetailsScreenMapper
) :
    DetailsScreenRepository {


    override suspend fun getProductDetails(): ProductDetailsItem {
        return productDetailsMapper.mapProductDetailsItemDBtoProductDetailsItem(
            detailsRemoteDataSource.getPhonesDetailsList()
        )
    }
}