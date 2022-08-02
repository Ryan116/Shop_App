package com.example.shopapp.features.mainScreen.data.dataSource.remote

import com.example.shopapp.features.mainScreen.data.network.modelRemote.MainRemote


interface MainRemoteDataSource {

    suspend fun getMainRemote(): MainRemote

}