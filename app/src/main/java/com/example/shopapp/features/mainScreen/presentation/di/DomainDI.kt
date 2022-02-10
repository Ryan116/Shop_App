package com.example.shopapp.features.mainScreen.presentation.di

import com.example.shopapp.features.mainScreen.domain.useCases.GetBestSellerListUseCase
import com.example.shopapp.features.mainScreen.domain.useCases.GetHomeStorePhonesListUseCase
import org.koin.dsl.module



val domainModule = module {
    factory<GetBestSellerListUseCase> {
        GetBestSellerListUseCase(mainScreenRepository = get() )
    }

    factory<GetHomeStorePhonesListUseCase> {
        GetHomeStorePhonesListUseCase(mainScreenRepository = get())
    }
}