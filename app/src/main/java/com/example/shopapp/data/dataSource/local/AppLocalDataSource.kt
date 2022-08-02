package com.example.shopapp.data.dataSource.local

import androidx.lifecycle.LiveData
import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB

interface AppLocalDataSource {

    fun getBookmarks(): LiveData<List<PhoneBookmarkDB>>
}