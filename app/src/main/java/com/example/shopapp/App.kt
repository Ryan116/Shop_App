package com.example.shopapp

import android.app.Application
import com.example.shopapp.di.appDataModule
import com.example.shopapp.di.appDomainModule
import com.example.shopapp.di.appPresentationModule
import com.example.shopapp.di.bookmarkScreenDataModule
import com.example.shopapp.di.bookmarkScreenDomainModule
import com.example.shopapp.di.bookmarkScreenPresentationModule
import com.example.shopapp.di.mainScreenDataModule
import com.example.shopapp.di.mainScreenDomainModule
import com.example.shopapp.di.mainScreenPresentationModule
import com.example.shopapp.di.myCartDataModule
import com.example.shopapp.di.myCartDomainModule
import com.example.shopapp.di.myCartPresentationModule
import com.example.shopapp.di.productDetailsDataModule
import com.example.shopapp.di.productDetailsDomainModule
import com.example.shopapp.di.productDetailsPresentationModule
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
                    bookmarkScreenPresentationModule,
                    appDataModule,
                    appDomainModule,
                    appPresentationModule
                )
            )
        }
    }
}