package com.example.shopapp.features.bookmarksScreen.data.mapper

import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB
import com.example.shopapp.features.bookmarksScreen.domain.model.PhoneBookmark

class BookmarkMapper {

    fun mapListBookmarkDBToListBookmark(listPhoneBookmarkDB: List<PhoneBookmarkDB>): List<PhoneBookmark> =
        listPhoneBookmarkDB.map {
            PhoneBookmark(
                id = it.id,
                title = it.title,
                priceWithoutDiscount = it.priceWithoutDiscount,
                discountPrice = it.discountPrice,
                picture = it.picture
            )
        }

    fun mapBookmarkToPhoneBookmarkDB(phoneBookmark: PhoneBookmark): PhoneBookmarkDB =
        PhoneBookmarkDB(
            id = phoneBookmark.id,
            title = phoneBookmark.title,
            picture = phoneBookmark.picture,
            priceWithoutDiscount = phoneBookmark.priceWithoutDiscount,
            discountPrice = phoneBookmark.discountPrice
        )
}