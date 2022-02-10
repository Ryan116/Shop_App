package com.example.shopapp.features.productDetailsScreen.data.mapper

import com.example.shopapp.features.mainScreen.domain.model.BestSeller
import com.example.shopapp.features.productDetailsScreen.data.modelDB.ProductDetailsItemDB
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem

class ProductDetailsScreenMapper {
    fun mapListProductDetailsItemDBToProductDetailsItem(listProductDetailsItemDB: List<ProductDetailsItemDB>): List<ProductDetailsItem> {

        val listProductDetailsItem: MutableList<ProductDetailsItem> = mutableListOf()

        listProductDetailsItemDB.forEach {
            val productDetailsItem = ProductDetailsItem(
                cpu = it.cpu,
                id = it.id,
                camera = it.camera,
                capacity = it.capacity,
                color = it.color,
                images = it.images,
                isFavorites = it.isFavorites,
                price = it.price,
                rating = it.rating,
                sd = it.sd,
                ssd = it.ssd,
                title = it.title
            )
            listProductDetailsItem.add(productDetailsItem)
        }
        return listProductDetailsItem
    }
}