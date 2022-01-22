package com.example.shopapp.features.mainScreen.data.remote

import com.example.shopapp.features.mainScreen.domain.model.Main


interface RemoteDataSource {

    suspend fun getPhonesList() : List<Main>

}