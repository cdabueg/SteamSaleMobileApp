package com.example.steamsaleapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.steamsaleapp.network.SteamApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface SteamUiState {
    data class Success(val games: String) : SteamUiState
    object Error : SteamUiState
    object Loading : SteamUiState
}

class SteamSaleViewModel: ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var steamUiState: SteamUiState by mutableStateOf(SteamUiState.Loading)
        private set

    /**
     * Call getSteamApps() on init so we can display status immediately.
     */
    init {
        getSteamApps()
    }

    /**
     * Gets Steam Sale information from the Steam API Retrofit service and updates the
     * [SteamGame] [List] [MutableList].
     */
    private fun getSteamApps() {
        viewModelScope.launch {
            steamUiState = try {
                val listResult = SteamApi.retrofitService.getSteamGames()
                SteamUiState.Success(listResult)
//                SteamUiState.Success(
//                    "Success: ${listResult.size} Steam games retrieved")
            } catch (e: IOException) {
                SteamUiState.Error
            }
        }
    }
}