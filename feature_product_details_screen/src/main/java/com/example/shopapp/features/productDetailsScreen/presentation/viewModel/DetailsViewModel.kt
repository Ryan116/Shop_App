package com.example.shopapp.features.productDetailsScreen.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem
import com.example.shopapp.features.productDetailsScreen.domain.useCases.GetProductDetailsUseCase
import com.example.shopapp.features.productDetailsScreen.domain.useCases.InsertProductDetailsToDBUseCase
import kotlinx.coroutines.launch


sealed class DetailsApiStatus() {
    class LOADING(): DetailsApiStatus()
    class ERROR(): DetailsApiStatus() {
        var exception: Exception? = null
    }
    class DONE(): DetailsApiStatus()
}

class DetailsViewModel(
    private val getProductDetailsUseCase: GetProductDetailsUseCase,
    private val insertProductDetailsToDBUseCase: InsertProductDetailsToDBUseCase
) : ViewModel() {


    private var _status = MutableLiveData<DetailsApiStatus>()
    val status: LiveData<DetailsApiStatus> = _status

    private var _phoneDetailsList = MutableLiveData<ProductDetailsItem>()
    val phoneDetailsList: LiveData<ProductDetailsItem> = _phoneDetailsList

    init {
        getPDItem()
    }


    private fun getPDItem() {

        viewModelScope.launch {
            _status.value = DetailsApiStatus.LOADING()
            try {
                insertProductDetailsToDBUseCase.insertProductDetailsToCache()
                _phoneDetailsList.value = getProductDetailsUseCase.getProductDetails()
                _status.value = DetailsApiStatus.DONE()
            } catch (e: Exception) {
                _status.value = DetailsApiStatus.ERROR()
                DetailsApiStatus.ERROR().exception = e
            }
        }
    }
}