package com.example.shopapp.features.myCartScreen.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.features.myCartScreen.data.network.MyCartApi
import com.example.shopapp.features.myCartScreen.data.remote.MyCartRemoteDataSourceImpl
import com.example.shopapp.features.myCartScreen.data.repository.MyCartRepositoryImpl
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.productDetailsScreen.data.network.ShopDetailsApi
import com.example.shopapp.features.productDetailsScreen.data.remote.DetailsRemoteDataSourceImpl
import com.example.shopapp.features.productDetailsScreen.data.repository.DetailsRepositoryImpl
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.presentation.viewModel.DetailsApiStatus
import kotlinx.coroutines.launch

enum class MyCartApiStatus { LOADING, ERROR, DONE }

class MyCartViewModel: ViewModel() {

    private val myCartApiService = MyCartApi.retrofitService
    private val myCartRemoteDataSource = MyCartRemoteDataSourceImpl(myCartApiService)
    private val repository = MyCartRepositoryImpl(myCartRemoteDataSource)

    private val _status = MutableLiveData<MyCartApiStatus>()
    val status: LiveData<MyCartApiStatus> = _status

    private val _myCartList = MutableLiveData<List<BasketMain>>()
    val myCartList: LiveData<List<BasketMain>> = _myCartList

    init {
        getMyCartModels()
    }



    private fun getMyCartModels() {

        viewModelScope.launch {
            _status.value = MyCartApiStatus.LOADING
            try {
                _myCartList.value = repository.getMyCart()
                _status.value = MyCartApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MyCartApiStatus.ERROR
            }
        }
    }
}