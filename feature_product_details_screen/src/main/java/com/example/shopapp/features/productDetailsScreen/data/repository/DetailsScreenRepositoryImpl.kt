package com.example.shopapp.features.productDetailsScreen.data.repository

import com.example.shopapp.features.productDetailsScreen.data.dataSource.local.PDLocalDataSource
import com.example.shopapp.features.productDetailsScreen.data.dataSource.remote.PDRemoteDataSource
import com.example.shopapp.features.productDetailsScreen.data.mapper.ProductDetailsScreenMapper
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository

class DetailsScreenRepositoryImpl(
    private val pdRemoteDataSource: PDRemoteDataSource,
    private val productDetailsMapper: ProductDetailsScreenMapper,
    private val pdLocalDataSource: PDLocalDataSource
) :
    DetailsScreenRepository {



    override suspend fun getProductDetails(): ProductDetailsItem {
        return productDetailsMapper.mapProductDetailsItemDBToProductDetailsItem(pdLocalDataSource.getProductDetails()[0])
    }

    override suspend fun insertProductDetailsToCache() {
        val productDetailsItemRemote = pdRemoteDataSource.getPhonesDetailsList()
        pdLocalDataSource.insertPDItemToCache(
            productDetailsMapper.mapProductDetailsItemRemoteToProductDetailsItemDB(
                productDetailsItemRemote
            )
        )

    }


}