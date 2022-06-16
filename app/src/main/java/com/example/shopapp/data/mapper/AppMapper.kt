package com.example.shopapp.data.mapper

import com.example.shopapp.common.database.data.modelDB.BookmarkDB
import com.example.shopapp.domain.model.Bookmark

class AppMapper {
    fun mapListBookmarkDBToBookmark(listBookmarkDB: List<BookmarkDB>): List<Bookmark> {

        val listBookmark: MutableList<Bookmark> = mutableListOf()

        listBookmarkDB.forEach {
            val bookmark = Bookmark(
                id = it.id,
                title = it.title,
                picture = it.picture,
                priceWithoutDiscount = it.priceWithoutDiscount,
                discountPrice = it.discountPrice

            )
            listBookmark.add(bookmark)
        }
        return listBookmark
    }
}