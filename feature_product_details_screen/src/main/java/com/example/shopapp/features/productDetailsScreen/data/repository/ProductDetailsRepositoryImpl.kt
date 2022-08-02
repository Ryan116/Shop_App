package com.example.shopapp.features.productDetailsScreen.data.repository

import com.example.shopapp.features.productDetailsScreen.data.dataSource.local.ProductDetailsLocalDataSource
import com.example.shopapp.features.productDetailsScreen.data.dataSource.remote.ProductDetailsRemoteDataSource
import com.example.shopapp.features.productDetailsScreen.data.mapper.ProductDetailsMapper
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.repository.ProductDetailsRepository

class ProductDetailsRepositoryImpl(
    private val productDetailsRemoteDataSource: ProductDetailsRemoteDataSource,
    private val productDetailsMapper: ProductDetailsMapper,
    private val productDetailsLocalDataSource: ProductDetailsLocalDataSource
) :
    ProductDetailsRepository {



    override suspend fun getProductDetails(): ProductDetailsItem {
        return productDetailsMapper.mapProductDetailsItemDBToProductDetailsItem(productDetailsLocalDataSource.getProductDetails()[0])
    }

    override suspend fun insertProductDetailsToCache() {
        val productDetailsItemRemote = productDetailsRemoteDataSource.getPhonesDetailsList()
        productDetailsLocalDataSource.insertPDItemToCache(
            productDetailsMapper.mapProductDetailsItemRemoteToProductDetailsItemDB(
                productDetailsItemRemote
            )
        )

    }


}