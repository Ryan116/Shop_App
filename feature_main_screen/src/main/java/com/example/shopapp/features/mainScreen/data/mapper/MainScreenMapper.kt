package com.example.shopapp.features.mainScreen.data.mapper

import com.example.shopapp.common.database.data.modelDB.BookmarkDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.BestSellerDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.HomeStoreDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.MainDB
import com.example.shopapp.features.mainScreen.data.network.modelRemote.BestSellerRemote
import com.example.shopapp.features.mainScreen.data.network.modelRemote.HomeStoreRemote
import com.example.shopapp.features.mainScreen.data.network.modelRemote.MainRemote
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore

class MainScreenMapper {
    fun mapListBestsellerDBToListBestseller(listBestsellerDB: List<BestSellerDB>): List<BestSeller> {

        val listBestseller: MutableList<BestSeller> = mutableListOf()

        listBestsellerDB.forEach {
            val bestSeller: BestSeller = BestSeller(
                id = it.id,
                isFavorites = it.isFavorites,
                title = it.title,
                priceWithoutDiscount = it.priceWithoutDiscount,
                discountPrice = it.discountPrice,
                picture = it.picture
            )
            listBestseller.add(bestSeller)
        }
        return listBestseller
    }

    fun mapListHomeStoreDBToListHomeStore(listHomeStoreDB: List<HomeStoreDB>): List<HomeStore> {

        val listHomeStore: MutableList<HomeStore> = mutableListOf()

        listHomeStoreDB.forEach {
            val homeStore = HomeStore(
                id = it.id,
                title = it.title,
                subtitle = it.subtitle,
                picture = it.picture,
                isBuy = it.isBuy
            )
            listHomeStore.add(homeStore)
        }
        return listHomeStore

    }

    fun mapBestsellerToBookmarkDB(bestSeller: BestSeller): BookmarkDB {
        return BookmarkDB(
            id = bestSeller.id,
            title = bestSeller.title,
            picture = bestSeller.picture,
            priceWithoutDiscount = bestSeller.priceWithoutDiscount,
            discountPrice = bestSeller.discountPrice
        )
    }

    fun mapListHomeStoreRemoteToListHomeStoreDB(listHomeStoreRemote: List<HomeStoreRemote>): List<HomeStoreDB> {

        val listHomeStoreDB: MutableList<HomeStoreDB> = mutableListOf()

        listHomeStoreRemote.forEach {
            val homeStoreDB = HomeStoreDB(
                id = it.id,
                title = it.title,
                subtitle = it.subtitle,
                picture = it.picture,
                isBuy = it.isBuy
            )
            listHomeStoreDB.add(homeStoreDB)
        }
        return listHomeStoreDB
    }

    fun mapListBestsellerRemoteToListBestsellerDB(listBestsellerRemote: List<BestSellerRemote>): List<BestSellerDB> {

        val listBestsellerDB: MutableList<BestSellerDB> = mutableListOf()

        listBestsellerRemote.forEach {
            val bestSellerDB = BestSellerDB(
                id = it.id,
                isFavorites = it.isFavorites,
                title = it.title,
                priceWithoutDiscount = it.priceWithoutDiscount,
                discountPrice = it.discountPrice,
                picture = it.picture
            )
            listBestsellerDB.add(bestSellerDB)
        }
        return listBestsellerDB
    }

    fun mapMainRemoteToMainDB(mainRemote: MainRemote): MainDB {
        return MainDB(
            homeStore = mapListHomeStoreRemoteToListHomeStoreDB(mainRemote.homeStore),
            bestSeller = mapListBestsellerRemoteToListBestsellerDB(mainRemote.bestSeller)
        )
    }
}