package com.example.shopapp.features.mainScreen.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.useCases.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


sealed class ShopApiStatus {
    object LOADING : ShopApiStatus()
    class ERROR(val error: String) : ShopApiStatus()
    object DONE : ShopApiStatus()
}

class MainViewModel(
    private val getBestSellerPhonesListUseCase: GetBestSellerPhonesListUseCase,
    private val getHomeStorePhonesListUseCase: GetHomeStorePhonesListUseCase,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    private val insertMainRemoteToDBUseCase: InsertMainRemoteToDBUseCase
) : ViewModel() {

    private val _status = MutableLiveData<ShopApiStatus>()
    val status: LiveData<ShopApiStatus> = _status

    private val _menuCategory = MutableLiveData<String>()
    val menuCategory: LiveData<String> = _menuCategory

    private val _homeStorePhonesList = MutableLiveData<List<HomeStore>>()
    val homeStorePhonesList: LiveData<List<HomeStore>> = _homeStorePhonesList

    private val _bestSellerPhonesList = MutableLiveData<List<BestSeller>>()
    val bestSellerPhonesList: LiveData<List<BestSeller>> = _bestSellerPhonesList

    var homeStoreListSize = MutableLiveData<Int>()
    val bestSellerListSize = MutableLiveData<Int>()


    init {
        getPhoneModels()
    }

    fun setMenuCategory(categoryName: String) {
        _menuCategory.value = categoryName
    }


    private fun getPhoneModels() {
        viewModelScope.launch {
            _status.value = ShopApiStatus.LOADING
            try {
                insertMainRemoteToDBUseCase.insertMainRemoteToDB()
                _status.value = ShopApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ShopApiStatus.ERROR(e.toString())
            }

            _homeStorePhonesList.value = getHomeStorePhonesListUseCase.getHomeStorePhonesList()
            _bestSellerPhonesList.value = getBestSellerPhonesListUseCase.getBestSellerPhonesList()
        }
    }

    fun addBookmark(bestSeller: BestSeller) {
        viewModelScope.launch(Dispatchers.IO) {
            addBookmarkUseCase.addBookmark(bestSeller)
        }
    }

    fun deleteBookmark(bestSeller: BestSeller) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteBookmarkUseCase.deleteBookmark(bestSeller)
        }
    }
}