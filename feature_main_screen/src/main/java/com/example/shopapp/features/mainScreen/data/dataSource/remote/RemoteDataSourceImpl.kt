package com.example.shopapp.features.mainScreen.data.dataSource.remote

import com.example.shopapp.features.mainScreen.data.network.ShopMainApiService
import com.example.shopapp.features.mainScreen.data.network.modelRemote.MainRemote


class RemoteDataSourceImpl(private val shopMainApiService: ShopMainApiService) : RemoteDataSource {

    override suspend fun getMainRemote(): MainRemote {
        return shopMainApiService.getMain()
    }

}