package com.example.shopapp.features.myCartScreen.presentation

sealed class MyCartApiStatus {
    object LOADING : MyCartApiStatus()
    class ERROR(val error: String) : MyCartApiStatus()
    object DONE : MyCartApiStatus()
}