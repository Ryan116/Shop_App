package com.example.shopapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopapp.domain.model.PhoneBookmark

interface AppRepository {

    fun getBookmarks(): LiveData<List<PhoneBookmark>>
}

