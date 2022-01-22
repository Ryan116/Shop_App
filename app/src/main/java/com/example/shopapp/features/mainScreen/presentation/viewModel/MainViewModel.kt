package com.example.shopapp.features.mainScreen.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.features.mainScreen.data.network.ShopMainApi
import com.example.shopapp.features.mainScreen.data.remote.RemoteDataSourceImpl
import com.example.shopapp.features.mainScreen.data.repository.MainScreenRepositoryImpl
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.model.Main
import kotlinx.coroutines.launch

enum class MarsApiStatus { LOADING, ERROR, DONE }

class MainViewModel: ViewModel() {

    private val shopMainApiService = ShopMainApi.retrofitService
    private val remoteDataSource = RemoteDataSourceImpl(shopMainApiService)
    private val repository = MainScreenRepositoryImpl(remoteDataSource)

    private val _status = MutableLiveData<MarsApiStatus>()
    val status: LiveData<MarsApiStatus> = _status

    private val _phones = MutableLiveData<List<HomeStore>>()
    val phones: LiveData<List<HomeStore>> = _phones

    init {
        getPhoneModels()
    }

    private fun getPhoneModels() {

        viewModelScope.launch {
                _phones.value = repository.getHomeStorePhonesList().value
                _status.value = MarsApiStatus.DONE
        }
    }
}