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
        return mainMapper.mapListBestsellerDBToListBestseller(
            mainLocalDataSource.getBestSellerDBPhonesList()
        )
    }

    override suspend fun getHomeStorePhonesList(): List<HomeStore> {
        return mainMapper.mapListHomeStoreDBToListHomeStore(
            mainLocalDataSource.getHomeStoreDBPhonesList()
        )
    }

    override suspend fun addBookmark(bestSeller: BestSeller) {
        mainLocalDataSource.addBookmark(mainMapper.mapBestsellerToBookmarkDB(bestSeller))
    }

    override suspend fun deleteBookmark(bestSeller: BestSeller) {
        mainLocalDataSource.deleteBookmark(mainMapper.mapBestsellerToBookmarkDB(bestSeller))
    }

    override suspend fun insertMainRemoteToDB() {
        withContext(Dispatchers.IO) {
            mainLocalDataSource.insertMainDBToDB(
                mainMapper.mapMainRemoteToMainDB(
                    mainRemoteDataSource.getMainRemote()
                )
            )
        }
    }
}