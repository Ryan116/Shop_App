package com.example.shopapp.data.mapper

import com.example.shopapp.common.bookmarkDatabase.data.modelDB.BookmarkDB
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

    fun mapBookmarkToBookmarkDB(bookmark: Bookmark): BookmarkDB {
        return BookmarkDB(
            id = bookmark.id,
            title = bookmark.title,
            picture = bookmark.picture,
            priceWithoutDiscount = bookmark.priceWithoutDiscount,
            discountPrice = bookmark.discountPrice
        )
    }
}