package com.example.shopapp.features.mainScreen.domain.useCases

import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.repository.MainRepository

class GetHomeStorePhonesListUseCase(private val mainRepository: MainRepository) {

    suspend fun getHomeStorePhonesList(): List<HomeStore> {
        return mainRepository.getHomeStorePhonesList()
    }
}