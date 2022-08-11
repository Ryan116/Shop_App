package com.example.shopapp.features.productDetailsScreen.presentation

sealed class DetailsApiStatus {
    object LOADING : DetailsApiStatus()
    class ERROR(val error: String) : DetailsApiStatus()
    object DONE : DetailsApiStatus()
}