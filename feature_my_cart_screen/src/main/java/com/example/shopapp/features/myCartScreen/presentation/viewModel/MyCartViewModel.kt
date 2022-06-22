package com.example.shopapp.features.myCartScreen.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.useCases.GetMyCartUseCase
import com.example.shopapp.features.myCartScreen.domain.useCases.InsertMyCartToDBUseCase
import kotlinx.coroutines.launch


sealed class MyCartApiStatus() {
    class LOADING(): MyCartApiStatus()
    class ERROR(): MyCartApiStatus() {
        var exception: Exception? = null
    }
    class DONE(): MyCartApiStatus()
}



class MyCartViewModel(
    private val getMyCartUseCase: GetMyCartUseCase,
    private val insertMyCartToDBUseCase: InsertMyCartToDBUseCase
) : ViewModel() {


    private val _status = MutableLiveData<MyCartApiStatus>()
    val status: LiveData<MyCartApiStatus> = _status

    private val _myCart = MutableLiveData<BasketMain>()
    val myCart: LiveData<BasketMain> = _myCart

    init {
        getMyCartModels()
    }


    private fun getMyCartModels() {

        viewModelScope.launch {
            _status.value = MyCartApiStatus.LOADING()
            try {
                insertMyCartToDBUseCase.insertMyCartToDB()
                _myCart.value = getMyCartUseCase.getMyCart()
                _status.value = MyCartApiStatus.DONE()
            } catch (e: Exception) {
                _status.value = MyCartApiStatus.ERROR()
                MyCartApiStatus.ERROR().exception = e
            }
        }
    }
}