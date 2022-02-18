package com.example.shopapp.features.mainScreen.data.repository

import com.example.shopapp.features.mainScreen.data.mapper.MainScreenMapper
import com.example.shopapp.features.mainScreen.data.remote.RemoteDataSource
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository

class MainScreenRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val mainScreenMapper: com.example.shopapp.features.mainScreen.data.mapper.MainScreenMapper
) :
    MainScreenRepository {


    override suspend fun getBestSellerPhonesList(): List<BestSeller> {
        return mainScreenMapper.mapListBestsellerDBToListBestseller(remoteDataSource.getBestSellerPhonesList())
    }

    override suspend fun getHomeStorePhonesList(): List<HomeStore> {
        return mainScreenMapper.mapListHomeStoreDBToListHomeStore(remoteDataSource.getHomeStorePhonesList())
    }


}