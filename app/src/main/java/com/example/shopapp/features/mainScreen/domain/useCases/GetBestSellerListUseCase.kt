package com.example.shopapp.features.mainScreen.domain.useCases

import androidx.lifecycle.LiveData
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.repository.MainScreenRepository

class GetBestSellerListUseCase(private val mainScreenRepository: MainScreenRepository) {
    suspend fun getBestSellerPhonesList(): List<BestSeller> {
        return mainScreenRepository.getBestSellerPhonesList()
    }
}
