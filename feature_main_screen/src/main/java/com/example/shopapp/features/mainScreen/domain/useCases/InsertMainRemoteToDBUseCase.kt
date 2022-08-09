package com.example.shopapp.features.mainScreen.domain.useCases

import com.example.shopapp.features.mainScreen.domain.repository.MainRepository

class InsertMainRemoteToDBUseCase(private val mainRepository: MainRepository) {

    suspend fun insertMainRemoteToDB() {
        return mainRepository.insertMainRemoteToDB()
    }
}