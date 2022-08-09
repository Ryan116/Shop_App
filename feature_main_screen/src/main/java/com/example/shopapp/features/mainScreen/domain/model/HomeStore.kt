package com.example.shopapp.features.mainScreen.domain.model

data class HomeStore(
    val id: Int,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBuy: Boolean,
)