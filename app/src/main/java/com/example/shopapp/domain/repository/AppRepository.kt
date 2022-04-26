package com.example.shopapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopapp.domain.model.Bookmark

interface AppRepository {
    suspend fun getBookmarks(): LiveData<List<Bookmark>>
}

