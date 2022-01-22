package com.example.shopapp.features.mainScreen.domain.useCases

import androidx.lifecycle.LiveData
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository

class GetHomeStorePhonesList(private val mainScreenRepository: MainScreenRepository) {
    suspend fun getHomeStorePhonesList(): LiveData<List<HomeStore>> {
        return mainScreenRepository.getHomeStorePhonesList()
    }
}