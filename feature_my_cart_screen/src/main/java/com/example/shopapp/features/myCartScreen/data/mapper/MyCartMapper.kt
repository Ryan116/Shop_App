package com.example.shopapp.features.myCartScreen.data.mapper

import com.example.shopapp.features.myCartScreen.data.cache.model.BasketMainDB
import com.example.shopapp.features.myCartScreen.data.cache.model.BasketProductDB
import com.example.shopapp.features.myCartScreen.data.network.model.BasketMainRemote
import com.example.shopapp.features.myCartScreen.data.network.model.BasketProductRemote
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.model.BasketProduct

class MyCartMapper {

    fun mapBasketMainRemoteToBasketMainDB(basketMainRemote: BasketMainRemote) =
        BasketMainDB(
            id = basketMainRemote.id.toInt(),
            basket = mapBasketProductRemoteToBasketProductDB(basketMainRemote.basket),
            delivery = basketMainRemote.delivery,
            total = basketMainRemote.total
        )

    private fun mapBasketProductRemoteToBasketProductDB(
        listBasketProductRemote: List<BasketProductRemote>
    ): List<BasketProductDB> = listBasketProductRemote.map {
        BasketProductDB(
            id = it.id,
            images = it.images,
            price = it.price,
            title = it.title
        )
    }

    private fun mapBasketProductDBToBasketProduct(
        listBasketProductDB: List<BasketProductDB>
    ): List<BasketProduct> = listBasketProductDB.map {
        BasketProduct(
            id = it.id,
            images = it.images,
            price = it.price,
            title = it.title
        )
    }

    fun mapListBasketMainDBToListBasketMain(
        listBasketMainDB: List<BasketMainDB>
    ): List<BasketMain> =
        listBasketMainDB.map {
            BasketMain(
                _id = it.id.toString(),
                basket = mapBasketProductDBToBasketProduct(it.basket),
                delivery = it.delivery,
                total = it.total
            )
        }
}