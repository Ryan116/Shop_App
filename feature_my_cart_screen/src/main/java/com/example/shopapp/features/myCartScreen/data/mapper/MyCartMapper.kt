package com.example.shopapp.features.myCartScreen.data.mapper

import com.example.shopapp.features.myCartScreen.data.cacheDB.modelDB.BasketMainDB
import com.example.shopapp.features.myCartScreen.data.cacheDB.modelDB.BasketProductDB
import com.example.shopapp.features.myCartScreen.data.network.modelRemote.BasketMainRemote
import com.example.shopapp.features.myCartScreen.data.network.modelRemote.BasketProductRemote
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.model.BasketProduct

class MyCartMapper {
    fun mapBasketMainRemoteToBasketMainDB(basketMainRemote: BasketMainRemote): BasketMainDB {
        return BasketMainDB(
            id = basketMainRemote.id.toInt(),
            basket = mapBasketProductRemoteToBasketProductDB(basketMainRemote.basket),
            delivery = basketMainRemote.delivery,
            total = basketMainRemote.total
        )
    }

    private fun mapBasketProductRemoteToBasketProductDB(listBasketProductRemote: List<BasketProductRemote>): List<BasketProductDB> {
        val listBasketProductDB: MutableList<BasketProductDB> = mutableListOf()

        listBasketProductRemote.forEach {
            val basketProductDB = BasketProductDB(
                id = it.id,
                images = it.images,
                price = it.price,
                title = it.title
            )
            listBasketProductDB.add(basketProductDB)
        }
        return listBasketProductDB
    }

    private fun mapBasketProductDBToBasketProduct(listBasketProductDB: List<BasketProductDB>): List<BasketProduct> {
        val listBasketProduct: MutableList<BasketProduct> = mutableListOf()

        listBasketProductDB.forEach {
            val basketProduct = BasketProduct(
                id = it.id,
                images = it.images,
                price = it.price,
                title = it.title
            )
            listBasketProduct.add(basketProduct)
        }
        return listBasketProduct
    }

    fun mapBasketMainDBToBasketMain(basketMainDB: BasketMainDB): BasketMain {
        return BasketMain(
            _id = basketMainDB.id.toString(),
            basket = mapBasketProductDBToBasketProduct(basketMainDB.basket),
            delivery = basketMainDB.delivery,
            total = basketMainDB.total
        )
    }

    fun maplistBasketMainDBToListBasketMain(listBasketMainDB: List<BasketMainDB>): List<BasketMain> {
        val listBasketMain: MutableList<BasketMain> = mutableListOf()

        listBasketMainDB.forEach {
            val basketMain = BasketMain(
                _id = it.id.toString(),
                basket = mapBasketProductDBToBasketProduct(it.basket),
                delivery = it.delivery,
                total = it.total
            )
            listBasketMain.add(basketMain)
        }
        return listBasketMain
    }

}