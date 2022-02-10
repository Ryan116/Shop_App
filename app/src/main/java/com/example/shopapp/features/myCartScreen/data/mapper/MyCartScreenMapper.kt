package com.example.shopapp.features.myCartScreen.data.mapper

import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.myCartScreen.data.modelDB.BasketMainDB
import com.example.shopapp.features.myCartScreen.data.modelDB.BasketProductDB
import com.example.shopapp.features.myCartScreen.domain.model.BasketMain
import com.example.shopapp.features.myCartScreen.domain.model.BasketProduct
import com.example.shopapp.features.productDetailsScreen.data.modelDB.ProductDetailsItemDB
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem

class MyCartScreenMapper {
    fun mapListBasketMainDBToBasketMain(listBasketMainDB: List<BasketMainDB>): List<BasketMain> {

        val listBasketMain: MutableList<BasketMain> = mutableListOf()


        listBasketMainDB.forEach {
            val basketMain = BasketMain(
                _id = it._id,
                basket = mapBasketProductDBToBasketProduct(it.basket),
                delivery = it.delivery,
                total = it.total

            )
            listBasketMain.add(basketMain)
        }
        return listBasketMain
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