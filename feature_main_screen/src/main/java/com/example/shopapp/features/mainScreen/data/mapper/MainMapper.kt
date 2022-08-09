package com.example.shopapp.features.mainScreen.data.mapper

import com.example.shopapp.common.database.data.modelDB.PhoneBookmarkDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.BestSellerDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.HomeStoreDB
import com.example.shopapp.features.mainScreen.data.cacheDB.modelDB.MainDB
import com.example.shopapp.features.mainScreen.data.network.modelRemote.BestSellerRemote
import com.example.shopapp.features.mainScreen.data.network.modelRemote.HomeStoreRemote
import com.example.shopapp.features.mainScreen.data.network.modelRemote.MainRemote
import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.mainScreen.domain.model.HomeStore

class MainMapper {

    fun mapListBestsellerDBToListBestseller(
        listBestsellerDB: List<BestSellerDB>
    ): List<BestSeller> =
        listBestsellerDB.map {
            BestSeller(
                id = it.id,
                isFavorites = it.isFavorites,
                title = it.title,
                priceWithoutDiscount = it.priceWithoutDiscount,
                discountPrice = it.discountPrice,
                picture = it.picture
            )
        }

    fun mapListHomeStoreDBToListHomeStore(listHomeStoreDB: List<HomeStoreDB>): List<HomeStore> =
        listHomeStoreDB.map {
            HomeStore(
                id = it.id,
                title = it.title,
                subtitle = it.subtitle,
                picture = it.picture,
                isBuy = it.isBuy
            )
        }

    fun mapBestsellerToBookmarkDB(bestSeller: BestSeller): PhoneBookmarkDB =
        PhoneBookmarkDB(
            id = bestSeller.id,
            title = bestSeller.title,
            picture = bestSeller.picture,
            priceWithoutDiscount = bestSeller.priceWithoutDiscount,
            discountPrice = bestSeller.discountPrice
        )

    private fun mapListHomeStoreRemoteToListHomeStoreDB(
        listHomeStoreRemote: List<HomeStoreRemote>
    ): List<HomeStoreDB> = listHomeStoreRemote.map {
        HomeStoreDB(
            id = it.id,
            title = it.title,
            subtitle = it.subtitle,
            picture = it.picture,
            isBuy = it.isBuy
        )
    }

    private fun mapListBestsellerRemoteToListBestsellerDB(
        listBestsellerRemote: List<BestSellerRemote>
    ): List<BestSellerDB> = listBestsellerRemote.map {
        BestSellerDB(
            id = it.id,
            isFavorites = it.isFavorites,
            title = it.title,
            priceWithoutDiscount = it.priceWithoutDiscount,
            discountPrice = it.discountPrice,
            picture = it.picture
        )
    }

    fun mapMainRemoteToMainDB(mainRemote: MainRemote): MainDB {
        return MainDB(
            homeStore = mapListHomeStoreRemoteToListHomeStoreDB(mainRemote.homeStore),
            bestSeller = mapListBestsellerRemoteToListBestsellerDB(mainRemote.bestSeller)
        )
    }
}