package com.example.shopapp.features.productDetailsScreen.di

import com.example.shopapp.features.productDetailsScreen.data.mapper.ProductDetailsScreenMapper
import com.example.shopapp.features.productDetailsScreen.data.network.ShopDetailsApi
import com.example.shopapp.features.productDetailsScreen.data.network.ShopDetailsApiService
import com.example.shopapp.features.productDetailsScreen.data.remote.DetailsRemoteDataSource
import com.example.shopapp.features.productDetailsScreen.data.remote.DetailsRemoteDataSourceImpl
import com.example.shopapp.features.productDetailsScreen.data.repository.DetailsScreenRepositoryImpl
import com.example.shopapp.features.productDetailsScreen.domain.repository.DetailsScreenRepository
import com.example.shopapp.features.productDetailsScreen.domain.useCases.GetProductDetailsUseCase
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val productDetailsDataModule = module {
    single<DetailsScreenRepository> {
        DetailsScreenRepositoryImpl(
            detailsRemoteDataSource = get(),
            productDetailsMapper = get()
        )
    }

    single<DetailsRemoteDataSource> {
        DetailsRemoteDataSourceImpl(detailsApiService = get())
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
}

val productDetailsPresentationModule = module {
    viewModel {
        DetailsViewModel(
            getProductDetailsUseCase = get()
        )
    }
}