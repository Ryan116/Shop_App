package com.example.shopapp.features.productDetailsScreen.di

import com.example.shopapp.features.productDetailsScreen.data.cacheDB.database.PDCacheDao
import com.example.shopapp.features.productDetailsScreen.data.cacheDB.database.ProductDetailsDatabase
import com.example.shopapp.features.productDetailsScreen.data.dataSource.local.PDLocalDataSource
import com.example.shopapp.features.productDetailsScreen.data.dataSource.local.PDLocalDataSourceImpl
import com.example.shopapp.features.productDetailsScreen.data.mapper.ProductDetailsScreenMapper
import com.example.shopapp.features.productDetailsScreen.data.network.ShopDetailsApi
import com.example.shopapp.features.productDetailsScreen.data.network.ShopDetailsApiService
import com.example.shopapp.features.productDetailsScreen.data.dataSource.remote.PDRemoteDataSource
import com.example.shopapp.features.productDetailsScreen.data.dataSource.remote.PDRemoteDataSourceImpl
import com.example.shopapp.features.productDetailsScreen.data.repository.DetailsScreenRepositoryImpl
import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository
import com.example.shopapp.features.productDetailsScreen.domain.useCases.GetProductDetailsUseCase
import com.example.shopapp.features.productDetailsScreen.domain.useCases.InsertProductDetailsToCacheUseCase
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.DetailsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val productDetailsDataModule = module {
    single<DetailsScreenRepository> {
        DetailsScreenRepositoryImpl(
            pdRemoteDataSource = get(),
            productDetailsMapper = get(),
            pdLocalDataSource = get()
        )
    }

    single<PDRemoteDataSource> {
        PDRemoteDataSourceImpl(detailsApiService = get())
    }

    single<PDLocalDataSource> {
        PDLocalDataSourceImpl(pdCacheDao = get())
    }

    single<PDCacheDao> {
        ProductDetailsDatabase.getDatabase(androidApplication()).productDetailsDao()
    }



    single<ShopDetailsApiService> {
        ShopDetailsApi.retrofitService
    }

    factory<ProductDetailsScreenMapper> {
        ProductDetailsScreenMapper()
    }
}

val productDetailsDomainModule = module {

    factory<GetProductDetailsUseCase> {
        GetProductDetailsUseCase(detailsScreenRepository = get() )
    }

    factory<InsertProductDetailsToCacheUseCase> {
        InsertProductDetailsToCacheUseCase(detailsScreenRepository = get())
    }
}

val productDetailsPresentationModule = module {
    viewModel {
        DetailsViewModel(
            getProductDetailsUseCase = get(),
            insertProductDetailsToCacheUseCase = get()
        )
    }
}