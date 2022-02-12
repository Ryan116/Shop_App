package com.example.shopapp.features.myCartScreen.di

import com.example.shopapp.features.myCartScreen.data.mapper.MyCartScreenMapper
import com.example.shopapp.features.myCartScreen.data.network.MyCartApi
import com.example.shopapp.features.myCartScreen.data.network.MyCartApiService
import com.example.shopapp.features.myCartScreen.data.remote.MyCartRemoteDataSource
import com.example.shopapp.features.myCartScreen.data.remote.MyCartRemoteDataSourceImpl
import com.example.shopapp.features.myCartScreen.data.repository.MyCartScreenRepositoryImpl
import com.example.shopapp.features.myCartScreen.domain.repository.MyCartScreenRepository
import com.example.shopapp.features.myCartScreen.domain.useCases.GetMyCartUseCase
import com.example.shopapp.features.myCartScreen.presentation.viewModel.MyCartViewModel
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

val myCartDataModule = module {
    single<MyCartScreenRepository> {
        MyCartScreenRepositoryImpl(
            myCartRemoteDataSource = get(),
            myCartScreenMapper = get()
        )
    }

    single<MyCartRemoteDataSource> {
        MyCartRemoteDataSourceImpl(myCartApiService = get())
    }

    single<MyCartApiService> {
        MyCartApi.retrofitService
    }

    factory<MyCartScreenMapper> {
        MyCartScreenMapper()
    }
}

val myCartDomainModule = module {
    factory<GetMyCartUseCase> {
        GetMyCartUseCase(myCartScreenRepository = get() )
    }
}

val myCartPresentationModule = module {
    viewModel {
        MyCartViewModel(
            getMyCartUseCase = get()
        )
    }
}