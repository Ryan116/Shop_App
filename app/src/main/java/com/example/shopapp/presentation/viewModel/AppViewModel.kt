package com.example.shopapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.shopapp.domain.model.PhoneBookmark
import com.example.shopapp.domain.usecase.GetBookmarksListUseCase

class AppViewModel(
    private val getBookmarksListUseCase: GetBookmarksListUseCase
) : ViewModel() {

    var bookmarksList: LiveData<List<PhoneBookmark>> = getBookmarksListUseCase.getBookmarksList()
}

