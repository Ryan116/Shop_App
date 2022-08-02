package com.example.shopapp.di

import com.example.shopapp.common.database.data.database.BookmarkDao
import com.example.shopapp.common.database.data.database.BookmarkDatabase
import com.example.shopapp.features.bookmarksScreen.data.dataSource.local.BookmarkLocalDataSource
import com.example.shopapp.features.bookmarksScreen.data.dataSource.local.BookmarkLocalDataSourceImpl
import com.example.shopapp.features.bookmarksScreen.data.mapper.BookmarkMapper
import com.example.shopapp.features.bookmarksScreen.data.repository.BookmarkRepositoryImpl
import com.example.shopapp.features.bookmarksScreen.domain.repository.BookmarkRepository
import com.example.shopapp.features.bookmarksScreen.domain.usecase.DeleteAllBookmarksUseCase
import com.example.shopapp.features.bookmarksScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.shopapp.features.bookmarksScreen.domain.usecase.GetBookmarksListUseCase
import com.example.shopapp.features.bookmarksScreen.presentation.viewModel.BookmarkViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bookmarkDataModule = module {

    single<BookmarkRepository> {
        BookmarkRepositoryImpl(
            bookmarkLocalDataSource = get(),
            bookmarkMapper = get()
        )
    }

    single<BookmarkLocalDataSource> {
        BookmarkLocalDataSourceImpl(bookmarkDao = get())
    }

    factory<BookmarkMapper> {
        BookmarkMapper()
    }

    single<BookmarkDao> {
        BookmarkDatabase.getDatabase(androidApplication()).bookmarkDao()
    }
}

val bookmarkDomainModule = module {

    factory<GetBookmarksListUseCase> {
        GetBookmarksListUseCase(bookmarkRepository = get())
    }

    factory<DeleteBookmarkUseCase> {
        DeleteBookmarkUseCase(bookmarkRepository = get())
    }

    factory<DeleteAllBookmarksUseCase> {
        DeleteAllBookmarksUseCase(bookmarkRepository = get())
    }
}

val bookmarkPresentationModule = module {

    viewModel {
        BookmarkViewModel(
            get(),
            get(),
            get()
        )
    }
}