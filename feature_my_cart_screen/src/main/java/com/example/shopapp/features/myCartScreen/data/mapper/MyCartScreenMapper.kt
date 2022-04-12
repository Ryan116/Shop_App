package com.example.shopapp.features.myCartScreen.data.mapper

import com.example.shopapp.features.myCartScreen.data.modelDB.BasketMainDB
import com.example.shopapp.features.myCartScreen.data.modelDB.BasketProductDB
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.model.BasketProduct

class MyCartScreenMapper {
    fun mapBasketMainDBToBasketMain(basketMainDB: BasketMainDB): BasketMain {
        return BasketMain(
            _id = basketMainDB.id,
            basket = mapBasketProductDBToBasketProduct(basketMainDB.basket),
            delivery = basketMainDB.delivery,
            total = basketMainDB.total
        )
    }

    fun mapBasketProductDBToBasketProduct(listBasketProductDB: List<BasketProductDB>): List<BasketProduct> {
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
}