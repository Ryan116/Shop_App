package com.example.shopapp.data.mapper

import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB
import com.example.shopapp.domain.model.PhoneBookmark

class AppMapper {

    fun mapListPhoneBookmarkDBToListPhoneBookmark(
        listPhoneBookmarkDB: List<PhoneBookmarkDB>
    ): List<PhoneBookmark> =
        listPhoneBookmarkDB.map {
            PhoneBookmark(
                id = it.id,
                title = it.title,
                picture = it.picture,
                priceWithoutDiscount = it.priceWithoutDiscount,
                discountPrice = it.discountPrice
            )
        }
}