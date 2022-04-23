package com.example.shopapp.common.bookmarkDatabase.data.modelDB

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "phone_table")
data class BookmarkDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val priceWithoutDiscount: Int,
    val discountPrice: Int,
    val picture: String
)


