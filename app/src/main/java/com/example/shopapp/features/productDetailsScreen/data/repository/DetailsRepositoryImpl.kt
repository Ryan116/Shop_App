package com.example.shopapp.features.productDetailsScreen.data.repository

import com.example.shopapp.features.productDetailsScreen.data.mapper.ProductDetailsScreenMapper
import com.example.shopapp.features.productDetailsScreen.data.remote.DetailsRemoteDataSource
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository

class DetailsRepositoryImpl(private val detailsRemoteDataSource: DetailsRemoteDataSource) :
    DetailsScreenRepository {

    private val productDetailsMapper = ProductDetailsScreenMapper()

    override suspend fun getProductDetails(): List<ProductDetailsItem> {
        return productDetailsMapper.mapListProductDetailsItemDBToProductDetailsItem(
            detailsRemoteDataSource.getPhonesDetailsList()
        )
    }
}