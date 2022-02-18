package com.example.shopapp.features.myCartScreen.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.useCases.GetMyCartUseCase
import kotlinx.coroutines.launch

enum class MyCartApiStatus { LOADING, ERROR, DONE }

class MyCartViewModel(
    private val getMyCartUseCase: GetMyCartUseCase
) : ViewModel() {


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
                _myCartList.value = getMyCartUseCase.getMyCart()
                _status.value = MyCartApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MyCartApiStatus.ERROR
            }
        }
    }
}