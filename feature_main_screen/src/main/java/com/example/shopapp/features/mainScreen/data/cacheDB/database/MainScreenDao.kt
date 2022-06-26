package com.example.shopapp.features.mainScreen.data.cacheDB.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.MainDB
import com.example.shopapp.features.mainScreen.data.network.modelRemote.MainRemote

@Dao
interface MainScreenDao {

    @Query("SELECT * FROM main_screen_cache")
    suspend fun getListMainDB(): List<MainDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMainDB(mainDB: MainDB)

}