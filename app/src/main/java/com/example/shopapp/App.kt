package com.example.shopapp

import android.app.Application
import com.example.shopapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    mainDataModule,
                    mainDomainModule,
                    mainPresentationModule,
                    productDetailsDataModule,
                    productDetailsDomainModule,
                    productDetailsPresentationModule,
                    myCartDataModule,
                    myCartDomainModule,
                    myCartPresentationModule,
                    bookmarkDataModule,
                    bookmarkDomainModule,
                    bookmarkPresentationModule,
                    appDataModule,
                    appDomainModule,
                    appPresentationModule
                )
            )
        }
    }
}