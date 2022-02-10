package com.example.shopapp.features.mainScreen.domain.useCases

import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository

class GetHomeStorePhonesList(private val mainScreenRepository: MainScreenRepository) {
    suspend fun getHomeStorePhonesList(): List<HomeStore> {
        return mainScreenRepository.getHomeStorePhonesList()
    }
}