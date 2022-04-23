package com.example.shopapp

import android.app.Application
import com.example.shopapp.features.bookmarksScreen.di.bookmarkScreenDataModule
import com.example.shopapp.features.bookmarksScreen.di.bookmarkScreenDomainModule
import com.example.shopapp.features.bookmarksScreen.di.bookmarkScreenPresentationModule
import com.example.shopapp.features.mainScreen.di.mainScreenDataModule
import com.example.shopapp.features.mainScreen.di.mainScreenDomainModule
import com.example.shopapp.features.mainScreen.di.mainScreenPresentationModule
import com.example.shopapp.features.myCartScreen.di.myCartDataModule
import com.example.shopapp.features.myCartScreen.di.myCartDomainModule
import com.example.shopapp.features.myCartScreen.di.myCartPresentationModule
import com.example.shopapp.features.productDetailsScreen.di.productDetailsDataModule
import com.example.shopapp.features.productDetailsScreen.di.productDetailsDomainModule
import com.example.shopapp.features.productDetailsScreen.di.productDetailsPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    mainScreenDataModule,
                    mainScreenDomainModule,
                    mainScreenPresentationModule,
                    productDetailsDataModule,
                    productDetailsDomainModule,
                    productDetailsPresentationModule,
                    myCartDataModule,
                    myCartDomainModule,
                    myCartPresentationModule,
                    bookmarkScreenDataModule,
                    bookmarkScreenDomainModule,
                    bookmarkScreenPresentationModule
                )
            )
        }
    }
}