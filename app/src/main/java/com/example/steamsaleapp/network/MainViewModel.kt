package com.example.steamsaleapp.network

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.steamsaleapp.model.GamesList
import kotlinx.coroutines.launch
import java.io.IOException



class MainViewModel: ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var screenState: ScreenState by mutableStateOf(ScreenState.Loading)
        private set

    /**
     * Call getSteamApps() on init so we can display status immediately.
     */
    init {
        getSteamGames()
    }

    /**
     * Gets Steam Sale information from the Steam API Retrofit service and updates the
     * [GamesList] [List] [MutableList].
     */
    private fun getSteamGames() {
        viewModelScope.launch {
            screenState = try {
                val listResult = SteamApi.retrofitService.getSteamGames()
                ScreenState.Success(
                    listResult
                )
            } catch (e: IOException) {
                ScreenState.Error
            }
        }
    }
}