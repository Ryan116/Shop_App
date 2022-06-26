package com.example.shopapp.features.mainScreen.di

import com.example.shopapp.common.database.data.database.BookmarkDatabase
import com.example.shopapp.common.database.data.database.BookmarkDao
import com.example.shopapp.features.mainScreen.data.cacheDB.database.MainScreenDao
import com.example.shopapp.features.mainScreen.data.cacheDB.database.MainScreenDatabase
import com.example.shopapp.features.mainScreen.data.mapper.MainScreenMapper
import com.example.shopapp.features.mainScreen.data.network.ShopMainApi
import com.example.shopapp.features.mainScreen.data.network.ShopMainApiService
import com.example.shopapp.features.mainScreen.data.dataSource.remote.RemoteDataSource
import com.example.shopapp.features.mainScreen.data.dataSource.remote.RemoteDataSourceImpl
import com.example.shopapp.features.mainScreen.data.repository.MainScreenRepositoryImpl
import com.example.shopapp.features.mainScreen.data.dataSource.local.LocalDataSource
import com.example.shopapp.features.mainScreen.data.dataSource.local.LocalDataSourceImpl
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository
import com.example.shopapp.features.mainScreen.domain.useCases.*
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainScreenDataModule = module {
    single<MainScreenRepository> {
        MainScreenRepositoryImpl(
            remoteDataSource = get(),
            mainScreenMapper = get(),
            localDataSource = get()
        )
    }

    single<LocalDataSource> {
        LocalDataSourceImpl(
            bookmarkDao = get(),
            mainScreenDao = get()
        )
    }

    single<MainScreenDao> {
        MainScreenDatabase.getDatabase(androidApplication()).mainScreenDao()
    }

    single<BookmarkDao> {
        BookmarkDatabase.getDatabase(androidApplication()).bookmarkDao()
    }

    single<RemoteDataSource> {
        RemoteDataSourceImpl(shopMainApiService = get())
    }

    single<ShopMainApiService> {
        ShopMainApi.retrofitService
    }

    factory<MainScreenMapper> {
        MainScreenMapper()
    }
}

val mainScreenDomainModule = module {
    factory<GetBestSellerListUseCase> {
        GetBestSellerListUseCase(mainScreenRepository = get() )
    }

    factory<GetHomeStorePhonesListUseCase> {
        GetHomeStorePhonesListUseCase(mainScreenRepository = get())
    }

    factory<AddBookmarkUseCase> {
        AddBookmarkUseCase(mainScreenRepository = get())
    }

    factory<DeleteBookmarkUseCase> {
        DeleteBookmarkUseCase(mainScreenRepository = get())
    }

    factory<InsertMainRemoteToDBUseCase> {
        InsertMainRemoteToDBUseCase(mainScreenRepository = get())
    }
}

val mainScreenPresentationModule = module {
    viewModel {
        MainViewModel(
            getBestSellerListUseCase = get(),
            getHomeStorePhonesListUseCase = get(),
            addBookmarkUseCase = get(),
            deleteBookmarkUseCase = get(),
            insertMainRemoteToDBUseCase = get()
        )
    }
}