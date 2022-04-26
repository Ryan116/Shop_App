package com.example.shopapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shopapp.data.mapper.AppMapper
import com.example.shopapp.data.source.local.LocalDataSource
import com.example.shopapp.domain.model.Bookmark
import com.example.shopapp.domain.repository.AppRepository

class AppRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val appMapper: AppMapper
) : AppRepository {

    override suspend fun getBookmarks(): LiveData<List<Bookmark>> {
        val liveDataListBookmark = Transformations.map(localDataSource.getBookmarks()) {
            appMapper.mapListBookmarkDBToBookmark(it)
        }
        return liveDataListBookmark
    }
}