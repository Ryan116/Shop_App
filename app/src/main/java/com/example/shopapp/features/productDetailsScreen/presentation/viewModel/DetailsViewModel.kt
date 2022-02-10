package com.example.shopapp.features.productDetailsScreen.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.features.productDetailsScreen.data.network.ShopDetailsApi
import com.example.shopapp.features.productDetailsScreen.data.remote.DetailsRemoteDataSourceImpl
import com.example.shopapp.features.productDetailsScreen.data.repository.DetailsRepositoryImpl
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.useCases.GetProductDetailsUseCase
import kotlinx.coroutines.launch

enum class DetailsApiStatus { LOADING, ERROR, DONE }

class DetailsViewModel: ViewModel() {

    private val shopDetailsApiService = ShopDetailsApi.retrofitService
    private val detailsRemoteDataSource = DetailsRemoteDataSourceImpl(shopDetailsApiService)
    private val repository = DetailsRepositoryImpl(detailsRemoteDataSource)
    private val getProductDetailsUseCase = GetProductDetailsUseCase(repository)

    private val _status = MutableLiveData<DetailsApiStatus>()
    val status: LiveData<DetailsApiStatus> = _status

    private val _phoneDetailsList = MutableLiveData<List<ProductDetailsItem>>()
    val phoneDetailsList: LiveData<List<ProductDetailsItem>> = _phoneDetailsList

    init {
        getPDItemModels()
    }



    private fun getPDItemModels() {

        viewModelScope.launch {
            _status.value = DetailsApiStatus.LOADING
            try {
                _phoneDetailsList.value = getProductDetailsUseCase.getProductDetails()
                _status.value = DetailsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = DetailsApiStatus.ERROR
            }
        }
    }
}