package com.example.shopapp.features.productDetailsScreen.data.mapper

import com.example.shopapp.features.productDetailsScreen.data.cacheDB.modelDB.ProductDetailsItemDB
import com.example.shopapp.features.productDetailsScreen.data.network.model.ProductDetailsItemRemote
import com.example.shopapp.features.productDetailsScreen.domain.model.ProductDetailsItem

class ProductDetailsMapper {

    fun mapProductDetailsItemDBToProductDetailsItem(productDetailsItemDB: ProductDetailsItemDB) =
        ProductDetailsItem(
            cpu = productDetailsItemDB.cpu,
            id = productDetailsItemDB.id.toString(),
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

    fun mapProductDetailsItemRemoteToProductDetailsItemDB(productDetailsItemRemote: ProductDetailsItemRemote) =
        ProductDetailsItemDB(
            cpu = productDetailsItemRemote.cpu,
            id = productDetailsItemRemote.id.toInt(),
            camera = productDetailsItemRemote.camera,
            capacity = productDetailsItemRemote.capacity,
            color = productDetailsItemRemote.color,
            images = productDetailsItemRemote.images,
            isFavorites = productDetailsItemRemote.isFavorites,
            price = productDetailsItemRemote.price,
            rating = productDetailsItemRemote.rating,
            sd = productDetailsItemRemote.sd,
            ssd = productDetailsItemRemote.ssd,
            title = productDetailsItemRemote.title
        )
}