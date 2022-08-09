package com.example.shopapp.features.mainScreen.data.dataSource.remote

import com.example.shopapp.features.mainScreen.data.network.MainApiService
import com.example.shopapp.features.mainScreen.data.network.modelRemote.MainRemote

class MainRemoteDataSourceImpl(private val mainApiService: MainApiService) : MainRemoteDataSource {

    override suspend fun getMainRemote(): MainRemote {
        return mainApiService.getMain()
    }
}