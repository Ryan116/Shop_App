package com.example.shopapp.features.mainScreen.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore
import com.example.shopapp.features.mainScreen.domain.useCases.*
import com.example.shopapp.features.mainScreen.presentation.state.MainScreenStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getBestSellerPhonesListUseCase: GetBestSellerPhonesListUseCase,
    private val getHomeStorePhonesListUseCase: GetHomeStorePhonesListUseCase,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    private val insertMainRemoteToDBUseCase: InsertMainRemoteToDBUseCase
) : ViewModel() {

    private val _status = MutableLiveData<MainScreenStatus>()
    val status: LiveData<MainScreenStatus> = _status

    private val _menuCategory = MutableLiveData<String>()
    val menuCategory: LiveData<String> = _menuCategory

    private val _homeStorePhonesList = MutableLiveData<List<HomeStore>>()
    val homeStorePhonesList: LiveData<List<HomeStore>> = _homeStorePhonesList

    private val _bestSellerPhonesList = MutableLiveData<List<BestSeller>>()
    val bestSellerPhonesList: LiveData<List<BestSeller>> = _bestSellerPhonesList

    private val _homeStoreListSize = MutableLiveData<Int>()
    val homeStoreListSize: LiveData<Int> = _homeStoreListSize

    init {
        getPhoneModels()
    }

    fun setMenuCategory(categoryName: String) {
        _menuCategory.value = categoryName
    }

    private fun getPhoneModels() {
        viewModelScope.launch {
            _status.value = MainScreenStatus.LOADING
            try {
                insertMainRemoteToDBUseCase.insertMainRemoteToDB()
                _status.value = MainScreenStatus.DONE
            } catch (e: Exception) {
                _status.value = MainScreenStatus.ERROR(e.toString())
            }
            _homeStorePhonesList.value = getHomeStorePhonesListUseCase.getHomeStorePhonesList()
            _bestSellerPhonesList.value = getBestSellerPhonesListUseCase.getBestSellerPhonesList()
            _homeStoreListSize.value = homeStorePhonesList.value?.size
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