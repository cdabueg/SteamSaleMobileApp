package com.example.steamsaleapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.steamsaleapp.network.SteamApi
import kotlinx.coroutines.launch

class SteamSaleViewModel: ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var steamUiState: String by mutableStateOf("")
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getSteamApps()
    }

    /**
     * Gets Steam Sale information from the Steam API Retrofit service
     */
    private fun getSteamApps() {
        viewModelScope.launch {
            val listResult = SteamApi.retrofitService.getSteamApps()
            steamUiState = listResult
        }
    }
}