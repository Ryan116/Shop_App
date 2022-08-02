package com.example.shopapp.features.bookmarksScreen.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark
import com.example.shopapp.features.bookmarksScreen.domain.usecase.DeleteAllBookmarksUseCase
import com.example.shopapp.features.bookmarksScreen.domain.usecase.DeleteBookmarkUseCase
import com.example.shopapp.features.bookmarksScreen.domain.usecase.GetBookmarksListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookmarkViewModel(
    private val getBookmarksListUseCase: GetBookmarksListUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    private val deleteAllBookmarksUseCase: DeleteAllBookmarksUseCase
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




    fun deleteBookmark(bookmark: Bookmark) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteBookmarkUseCase.deleteBookmark(bookmark)
        }
    }

    fun deleteAllBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllBookmarksUseCase.deleteAllBookmarks()
        }
    }


}

