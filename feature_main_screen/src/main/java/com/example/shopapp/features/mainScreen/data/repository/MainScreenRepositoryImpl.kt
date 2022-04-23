package com.example.shopapp.features.mainScreen.data.repository

import com.example.shopapp.features.mainScreen.data.mapper.MainScreenMapper
import com.example.shopapp.features.mainScreen.data.source.local.LocalDataSource
import com.example.shopapp.features.mainScreen.data.source.remote.RemoteDataSource
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository

class MainScreenRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val mainScreenMapper: MainScreenMapper
) : MainScreenRepository {


    override suspend fun getBestSellerPhonesList(): List<BestSeller> {
        return mainScreenMapper.mapListBestsellerDBToListBestseller(remoteDataSource.getBestSellerPhonesList())
    }

    override suspend fun getHomeStorePhonesList(): List<HomeStore> {
        return mainScreenMapper.mapListHomeStoreDBToListHomeStore(remoteDataSource.getHomeStorePhonesList())
    }

    override suspend fun addBookmark(bestSeller: BestSeller) {
        localDataSource.addBookmark(mainScreenMapper.mapBestsellerToBookmarkDB(bestSeller))
    }

    override suspend fun deleteBookmark(bestSeller: BestSeller) {
        localDataSource.deleteBookmark(mainScreenMapper.mapBestsellerToBookmarkDB(bestSeller))
    }


}