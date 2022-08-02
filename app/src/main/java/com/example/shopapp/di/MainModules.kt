package com.example.shopapp.di

import com.example.shopapp.features.mainScreen.data.cacheDB.database.MainScreenDao
import com.example.shopapp.features.mainScreen.data.cacheDB.database.MainScreenDatabase
import com.example.shopapp.features.mainScreen.data.dataSource.local.MainLocalDataSource
import com.example.shopapp.features.mainScreen.data.dataSource.local.MainLocalDataSourceImpl
import com.example.shopapp.features.mainScreen.data.dataSource.remote.MainRemoteDataSource
import com.example.shopapp.features.mainScreen.data.dataSource.remote.MainRemoteDataSourceImpl
import com.example.shopapp.features.mainScreen.data.mapper.MainMapper
import com.example.shopapp.features.mainScreen.data.network.MainApi
import com.example.shopapp.features.mainScreen.data.network.MainApiService
import com.example.shopapp.features.mainScreen.data.repository.MainRepositoryImpl
import com.example.shopapp.features.mainScreen.domain.repository.MainRepository
import com.example.shopapp.features.mainScreen.domain.useCases.*
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainDataModule = module {

    single<MainRepository> {
        MainRepositoryImpl(
            mainRemoteDataSource = get(),
            mainMapper = get(),
            mainLocalDataSource = get()
        )
    }

    single<MainLocalDataSource> {
        MainLocalDataSourceImpl(
            bookmarkDao = get(),
            mainScreenDao = get()
        )
    }

    single<MainScreenDao> {
        MainScreenDatabase.getDatabase(androidApplication()).mainScreenDao()
    }

    single<MainRemoteDataSource> {
        MainRemoteDataSourceImpl(mainApiService = get())
    }

    single<MainApiService> {
        MainApi.retrofitService
    }

    factory<MainMapper> {
        MainMapper()
    }
}

val mainDomainModule = module {

    factory<GetBestSellerPhonesListUseCase> {
        GetBestSellerPhonesListUseCase(mainRepository = get() )
    }

    factory<GetHomeStorePhonesListUseCase> {
        GetHomeStorePhonesListUseCase(mainRepository = get())
    }

    factory<AddBookmarkUseCase> {
        AddBookmarkUseCase(mainRepository = get())
    }

    factory<DeleteBookmarkUseCase> {
        DeleteBookmarkUseCase(mainRepository = get())
    }

    factory<InsertMainRemoteToDBUseCase> {
        InsertMainRemoteToDBUseCase(mainRepository = get())
    }
}

val mainPresentationModule = module {
    viewModel {
        MainViewModel(
            getBestSellerPhonesListUseCase = get(),
            getHomeStorePhonesListUseCase = get(),
            addBookmarkUseCase = get(),
            deleteBookmarkUseCase = get(),
            insertMainRemoteToDBUseCase = get()
        )
    }
}