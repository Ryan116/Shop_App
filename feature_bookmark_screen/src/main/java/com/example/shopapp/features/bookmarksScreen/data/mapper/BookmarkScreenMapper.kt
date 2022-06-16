package com.example.shopapp.features.bookmarksScreen.data.mapper

import com.example.shopapp.common.database.data.modelDB.BookmarkDB
import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark

class BookmarkScreenMapper {
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