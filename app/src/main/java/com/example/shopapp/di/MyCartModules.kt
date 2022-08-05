package com.example.shopapp.di

import com.example.shopapp.features.myCartScreen.data.cacheDB.database.MyCartDao
import com.example.shopapp.features.myCartScreen.data.cacheDB.database.MyCartDatabase
import com.example.shopapp.features.myCartScreen.data.dataSource.local.MyCartLocalDataSource
import com.example.shopapp.features.myCartScreen.data.dataSource.local.MyCartLocalDataSourceImpl
import com.example.shopapp.features.myCartScreen.data.dataSource.remote.MyCartRemoteDataSource
import com.example.shopapp.features.myCartScreen.data.dataSource.remote.MyCartRemoteDataSourceImpl
import com.example.shopapp.features.myCartScreen.data.mapper.MyCartMapper
import com.example.shopapp.features.myCartScreen.data.network.MyCartApi
import com.example.shopapp.features.myCartScreen.data.network.MyCartApiService
import com.example.shopapp.features.myCartScreen.data.repository.MyCartRepositoryImpl
import com.example.shopapp.features.myCartScreen.domain.repository.MyCartRepository
import com.example.shopapp.features.myCartScreen.domain.useCases.GetMyCartUseCase
import com.example.shopapp.features.myCartScreen.domain.useCases.InsertMyCartToDBUseCase
import com.example.shopapp.features.myCartScreen.presentation.viewModel.MyCartViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myCartDataModule = module {

    single<MyCartRepository> {
        MyCartRepositoryImpl(
            myCartRemoteDataSource = get(),
            myCartMapper = get(),
            myCartLocalDataSource = get()
        )
    }

    single<MyCartLocalDataSource> {
        MyCartLocalDataSourceImpl(myCartDao = get())
    }

    single<MyCartDao> {
        MyCartDatabase.getDatabase(androidApplication()).myCartDao()
    }

    single<MyCartRemoteDataSource> {
        MyCartRemoteDataSourceImpl(myCartApiService = get())
    }

    single<MyCartApiService> {
        MyCartApi.retrofitService
    }

    factory<MyCartMapper> {
        MyCartMapper()
    }
}

val myCartDomainModule = module {

    factory<GetMyCartUseCase> {
        GetMyCartUseCase(myCartRepository = get())
    }

    factory<InsertMyCartToDBUseCase> {
        InsertMyCartToDBUseCase(myCartRepository = get())
    }
}

val myCartPresentationModule = module {

    viewModel {
        MyCartViewModel(
            getMyCartUseCase = get(),
            insertMyCartToDBUseCase = get()
        )
    }
}