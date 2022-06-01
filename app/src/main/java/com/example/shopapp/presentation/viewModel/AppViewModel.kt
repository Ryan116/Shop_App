package com.example.shopapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.domain.model.Bookmark
import com.example.shopapp.domain.usecase.GetBookmarksListUseCase
import kotlinx.coroutines.launch

class AppViewModel(
    private val getBookmarksListUseCase: GetBookmarksListUseCase
) : ViewModel() {


    lateinit var bookmarksList: LiveData<List<Bookmark>>


    init {
        getBookmarksList()
    }

    private fun getBookmarksList() {
        viewModelScope.launch {
            bookmarksList = getBookmarksListUseCase.getBookmarksList()
        }
    }

}

