package com.example.shopapp.di

import com.example.shopapp.features.productDetailsScreen.data.cacheDB.database.ProductDetailsDao
import com.example.shopapp.features.productDetailsScreen.data.cacheDB.database.ProductDetailsDatabase
import com.example.shopapp.features.productDetailsScreen.data.dataSource.local.ProductDetailsLocalDataSource
import com.example.shopapp.features.productDetailsScreen.data.dataSource.local.ProductDetailsLocalDataSourceImpl
import com.example.shopapp.features.productDetailsScreen.data.dataSource.remote.ProductDetailsRemoteDataSource
import com.example.shopapp.features.productDetailsScreen.data.dataSource.remote.ProductDetailsRemoteDataSourceImpl
import com.example.shopapp.features.productDetailsScreen.data.mapper.ProductDetailsMapper
import com.example.shopapp.features.productDetailsScreen.data.network.ProductDetailsApi
import com.example.shopapp.features.productDetailsScreen.data.network.ProductDetailsApiService
import com.example.shopapp.features.productDetailsScreen.data.repository.ProductDetailsRepositoryImpl
import com.example.shopapp.features.productDetailsScreen.domain.repository.ProductDetailsRepository
import com.example.shopapp.features.productDetailsScreen.domain.useCases.GetProductDetailsUseCase
import com.example.shopapp.features.productDetailsScreen.domain.useCases.InsertProductDetailsToDBUseCase
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.ProductDetailsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val productDetailsDataModule = module {

    single<ProductDetailsRepository> {
        ProductDetailsRepositoryImpl(
            productDetailsRemoteDataSource = get(),
            productDetailsMapper = get(),
            productDetailsLocalDataSource = get()
        )
    }

    single<ProductDetailsRemoteDataSource> {
        ProductDetailsRemoteDataSourceImpl(productDetailsApiService = get())
    }

    single<ProductDetailsLocalDataSource> {
        ProductDetailsLocalDataSourceImpl(productDetailsDao = get())
    }

    single<ProductDetailsDao> {
        ProductDetailsDatabase.getDatabase(androidApplication()).productDetailsDao()
    }

    single<ProductDetailsApiService> {
        ProductDetailsApi.retrofitService
    }

    factory<ProductDetailsMapper> {
        ProductDetailsMapper()
    }
}

val productDetailsDomainModule = module {

    factory<GetProductDetailsUseCase> {
        GetProductDetailsUseCase(productDetailsRepository = get())
    }

    factory<InsertProductDetailsToDBUseCase> {
        InsertProductDetailsToDBUseCase(productDetailsRepository = get())
    }
}

val productDetailsPresentationModule = module {

    viewModel {
        ProductDetailsViewModel(
            getProductDetailsUseCase = get(),
            insertProductDetailsToDBUseCase = get()
        )
    }
}