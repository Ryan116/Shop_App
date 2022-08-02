package com.example.shopapp.features.mainScreen.data.repository

import com.example.shopapp.features.mainScreen.data.dataSource.local.MainLocalDataSource
import com.example.shopapp.features.mainScreen.data.dataSource.remote.MainRemoteDataSource
import com.example.shopapp.features.mainScreen.data.mapper.MainMapper
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepositoryImpl(
    private val mainRemoteDataSource: MainRemoteDataSource,
    private val mainLocalDataSource: MainLocalDataSource,
    private val mainMapper: MainMapper
) : MainRepository {


    override suspend fun getBestSellerPhonesList(): List<BestSeller> {
        val listBestSellerDB = mainLocalDataSource.getBestSellerDBPhonesList()
        return mainMapper.mapListBestsellerDBToListBestseller(listBestSellerDB)
    }

    override suspend fun getHomeStorePhonesList(): List<HomeStore> {
        val listHomeStoreDB = mainLocalDataSource.getHomeStoreDBPhonesList()
        return mainMapper.mapListHomeStoreDBToListHomeStore(listHomeStoreDB)
    }

    override suspend fun addBookmark(bestSeller: BestSeller) {
        mainLocalDataSource.addBookmark(mainMapper.mapBestsellerToBookmarkDB(bestSeller))


    }

    override suspend fun deleteBookmark(bestSeller: BestSeller) {
        mainLocalDataSource.deleteBookmark(mainMapper.mapBestsellerToBookmarkDB(bestSeller))


    }

    override suspend fun insertMainRemoteToDB() {
        val mainRemote = mainRemoteDataSource.getMainRemote()
        withContext(Dispatchers.IO) {
            val mainDB = mainMapper.mapMainRemoteToMainDB(mainRemote)
            mainLocalDataSource.insertMainDBToDB(mainDB)
        }

    }


}