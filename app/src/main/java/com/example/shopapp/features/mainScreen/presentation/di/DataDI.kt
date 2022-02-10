package com.example.shopapp.features.mainScreen.presentation.di

import com.example.shopapp.features.mainScreen.data.network.ShopMainApi
import com.example.shopapp.features.mainScreen.data.network.ShopMainApiService
import com.example.shopapp.features.mainScreen.data.remote.RemoteDataSource
import com.example.shopapp.features.mainScreen.data.remote.RemoteDataSourceImpl
import com.example.shopapp.features.mainScreen.data.repository.MainScreenRepositoryImpl
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository
import org.koin.dsl.module






val dataModule = module {
    single<MainScreenRepository> {
        MainScreenRepositoryImpl(remoteDataSource = get())
    }

    single<RemoteDataSource> {
        RemoteDataSourceImpl(shopMainApiService = get())
    }

    single<ShopMainApiService> {
        ShopMainApi.retrofitService
    }
}