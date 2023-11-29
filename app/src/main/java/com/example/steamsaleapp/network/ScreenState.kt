package com.example.steamsaleapp.network

import com.example.steamsaleapp.model.GamesList

sealed interface ScreenState {
    data class Success(val games: GamesList) : ScreenState
    object Error : ScreenState
    object Loading : ScreenState
}