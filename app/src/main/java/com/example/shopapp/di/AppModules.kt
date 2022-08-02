package com.example.shopapp.di

import com.example.shopapp.common.database.data.database.BookmarkDao
import com.example.shopapp.common.database.data.database.BookmarkDatabase
import com.example.shopapp.data.mapper.AppMapper
import com.example.shopapp.data.repository.AppRepositoryImpl
import com.example.shopapp.data.dataSource.local.AppLocalDataSource
import com.example.shopapp.data.dataSource.local.AppLocalDataSourceImpl
import com.example.shopapp.domain.repository.AppRepository
import com.example.shopapp.domain.usecase.GetBookmarksListUseCase
import com.example.shopapp.presentation.viewModel.AppViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appDataModule = module {

    single<AppRepository> {
        AppRepositoryImpl(
            appLocalDataSource = get()
            , appMapper = get())
    }

    single<AppLocalDataSource> {
        AppLocalDataSourceImpl(bookmarkDao = get())
    }

    factory<AppMapper> {
        AppMapper()
    }

    single<BookmarkDao> {
        BookmarkDatabase.getDatabase(androidApplication()).bookmarkDao()
    }
}

val appDomainModule = module {

    factory<GetBookmarksListUseCase> {
        GetBookmarksListUseCase(appRepository = get())
    }
}

val appPresentationModule = module {

    viewModel {
        AppViewModel(
            get()
        )
    }
}