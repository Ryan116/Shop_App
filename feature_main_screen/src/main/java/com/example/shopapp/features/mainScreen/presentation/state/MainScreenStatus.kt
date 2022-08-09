package com.example.shopapp.features.mainScreen.presentation.state

sealed class MainScreenStatus {
    object LOADING : MainScreenStatus()
    class ERROR(val error: String) : MainScreenStatus()
    object DONE : MainScreenStatus()
}