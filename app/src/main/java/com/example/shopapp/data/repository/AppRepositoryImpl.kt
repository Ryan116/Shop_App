package com.example.shopapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shopapp.data.mapper.AppMapper
import com.example.shopapp.data.dataSource.local.AppLocalDataSource
import com.example.shopapp.domain.model.PhoneBookmark
import com.example.shopapp.domain.repository.AppRepository

class AppRepositoryImpl(
    private val appLocalDataSource: AppLocalDataSource,
    private val appMapper: AppMapper
) : AppRepository {

    override fun getBookmarks(): LiveData<List<PhoneBookmark>> {
        return Transformations.map(appLocalDataSource.getBookmarks()) {
            appMapper.mapListPhoneBookmarkDBToListPhoneBookmark(it)
        }
    }
}