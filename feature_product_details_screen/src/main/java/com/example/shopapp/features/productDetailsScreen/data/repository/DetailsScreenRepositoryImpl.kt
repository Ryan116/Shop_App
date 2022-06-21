package com.example.shopapp.features.productDetailsScreen.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private var _productDetailsItemLive = MutableLiveData<ProductDetailsItem>()
    val productDetailsItemLive: LiveData<ProductDetailsItem> = _productDetailsItemLive



    override suspend fun getProductDetails(): LiveData<ProductDetailsItem> {

        val productDetailsItemDB = pdLocalDataSource.getProductDetails()[0]
        _productDetailsItemLive.value = productDetailsMapper.mapProductDetailsItemDBToProductDetailsItem(productDetailsItemDB)
        return productDetailsItemLive
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