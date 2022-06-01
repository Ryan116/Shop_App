package com.example.shopapp.features.productDetailsScreen.data.mapper

import com.example.shopapp.features.productDetailsScreen.data.modelDB.ProductDetailsItemDB
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem

class ProductDetailsScreenMapper {

    fun mapProductDetailsItemDBtoProductDetailsItem(productDetailsItemDB: ProductDetailsItemDB): ProductDetailsItem {
        return ProductDetailsItem(
            cpu = productDetailsItemDB.cpu,
            id = productDetailsItemDB.id,
            camera = productDetailsItemDB.camera,
            capacity = productDetailsItemDB.capacity,
            color = productDetailsItemDB.color,
            images = productDetailsItemDB.images,
            isFavorites = productDetailsItemDB.isFavorites,
            price = productDetailsItemDB.price,
            rating = productDetailsItemDB.rating,
            sd = productDetailsItemDB.sd,
            ssd = productDetailsItemDB.ssd,
            title = productDetailsItemDB.title
        )
    }
}