package com.example.shopapp.features.mainScreen.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopapp.features.mainScreen.data.remote.RemoteDataSource
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository

class MainScreenRepositoryImpl(private val remoteDataSource: RemoteDataSource) :
    MainScreenRepository {

    private var phonesBestSellerListLD = MutableLiveData<List<BestSeller>>()
    private var phonesHomeStoreListLD = MutableLiveData<List<HomeStore>>()




    override suspend fun getBestSellerPhonesList(): LiveData<List<BestSeller>> {
        phonesBestSellerListLD.value = remoteDataSource.getPhonesList()[0].bestSeller
        return phonesBestSellerListLD

    }

    override suspend fun getHomeStorePhonesList(): LiveData<List<HomeStore>> {
        phonesHomeStoreListLD.value = remoteDataSource.getPhonesList()[0].homeStore
        return phonesHomeStoreListLD
    }
}