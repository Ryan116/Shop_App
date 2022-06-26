package com.example.shopapp.features.mainScreen.data.repository

import com.example.shopapp.features.mainScreen.data.mapper.MainScreenMapper
import com.example.shopapp.features.mainScreen.data.dataSource.local.LocalDataSource
import com.example.shopapp.features.mainScreen.data.dataSource.remote.RemoteDataSource
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository

class MainScreenRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val mainScreenMapper: MainScreenMapper
) : MainScreenRepository {


    override suspend fun getBestSellerPhonesList(): List<BestSeller> {
        val listBestSellerDB = localDataSource.getBestSellerDBPhonesList()
        return mainScreenMapper.mapListBestsellerDBToListBestseller(listBestSellerDB)
    }

    override suspend fun getHomeStorePhonesList(): List<HomeStore> {
        val listHomeStoreDB = localDataSource.getHomeStoreDBPhonesList()
        return mainScreenMapper.mapListHomeStoreDBToListHomeStore(listHomeStoreDB)
    }

    override suspend fun addBookmark(bestSeller: BestSeller) {
        localDataSource.addBookmark(mainScreenMapper.mapBestsellerToBookmarkDB(bestSeller))
    }

    override suspend fun deleteBookmark(bestSeller: BestSeller) {
        localDataSource.deleteBookmark(mainScreenMapper.mapBestsellerToBookmarkDB(bestSeller))
    }

    override suspend fun insertMainRemoteToDB() {
        val mainRemote = remoteDataSource.getMainRemote()
        val mainDB = mainScreenMapper.mapMainRemoteToMainDB(mainRemote)
        localDataSource.insertMainDBToDB(mainDB)
    }


}