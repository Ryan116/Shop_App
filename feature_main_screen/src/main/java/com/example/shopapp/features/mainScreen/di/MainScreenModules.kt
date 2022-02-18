package com.example.shopapp.features.mainScreen.di

import com.example.shopapp.features.mainScreen.data.mapper.MainScreenMapper
import com.example.shopapp.features.mainScreen.data.network.ShopMainApi
import com.example.shopapp.features.mainScreen.data.network.ShopMainApiService
import com.example.shopapp.features.mainScreen.data.remote.RemoteDataSource
import com.example.shopapp.features.mainScreen.data.remote.RemoteDataSourceImpl
import com.example.shopapp.features.mainScreen.data.repository.MainScreenRepositoryImpl
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository
import com.example.shopapp.features.mainScreen.domain.useCases.GetBestSellerListUseCase
import com.example.shopapp.features.mainScreen.domain.useCases.GetHomeStorePhonesListUseCase
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainScreenDataModule = module {
    single<MainScreenRepository> {
        MainScreenRepositoryImpl(
            remoteDataSource = get(),
            mainScreenMapper = get()
        )
    }

    single<RemoteDataSource> {
        RemoteDataSourceImpl(shopMainApiService = get())
    }

    single<ShopMainApiService> {
        ShopMainApi.retrofitService
    }

    factory<com.example.shopapp.features.mainScreen.data.mapper.MainScreenMapper> {
        com.example.shopapp.features.mainScreen.data.mapper.MainScreenMapper()
    }
}

val mainScreenDomainModule = module {
    factory<GetBestSellerListUseCase> {
        GetBestSellerListUseCase(mainScreenRepository = get() )
    }

    factory<GetHomeStorePhonesListUseCase> {
        GetHomeStorePhonesListUseCase(mainScreenRepository = get())
    }
}

val mainScreenPresentationModule = module {
    viewModel {
        MainViewModel(
            getBestSellerListUseCase = get(),
            getHomeStorePhonesListUseCase = get()
        )
    }
}