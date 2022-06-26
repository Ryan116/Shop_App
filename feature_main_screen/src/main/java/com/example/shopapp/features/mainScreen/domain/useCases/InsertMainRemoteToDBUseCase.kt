package com.example.shopapp.features.mainScreen.domain.useCases

import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository

class InsertMainRemoteToDBUseCase(private val mainScreenRepository: MainScreenRepository) {
    suspend fun insertMainRemoteToDB(){
        return mainScreenRepository.insertMainRemoteToDB()
    }
}