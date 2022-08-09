package com.example.shopapp.features.mainScreen.domain.useCases

import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.repository.MainRepository

class GetBestSellerPhonesListUseCase(private val mainRepository: MainRepository) {

    suspend fun getBestSellerPhonesList(): List<BestSeller> {
        return mainRepository.getBestSellerPhonesList()
    }
}
