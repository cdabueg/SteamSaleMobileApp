package com.example.steamsaleapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.steamsaleapp.SteamSaleApplication
import com.example.steamsaleapp.data.SteamGamesListRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the SteamMainContent screen
 */
sealed interface SteamUiState {
    // Requires primary constructor parameter. val gamesList
    data class Success(val gamesList: String) : SteamUiState
    object Error : SteamUiState
    object Loading : SteamUiState
}

class SteamViewModel(private val steamGamesListRepository: SteamGamesListRepository) : ViewModel(){
    /** The mutable State that stores the status of the most recent request */
    var steamUiState: SteamUiState by mutableStateOf(SteamUiState.Loading)
        private set

    /**
     * Call getSteamGamesList() on init so we can display status immediately.
     */
    init {
        getSteamGamesList()
    }

    /**
     * Gets Steam games list from the Steam API Retrofit service
     */
    fun getSteamGamesList() {
        viewModelScope.launch {
            steamUiState = SteamUiState.Loading
            steamUiState = try {
                val listResult = steamGamesListRepository.getSteamGamesList()
                SteamUiState.Success(
                    "Success: ${listResult.applist.apps.size} Steam Games on the list."
                )
            } catch (e: IOException) {
                SteamUiState.Error
            } catch (e: HttpException) {
                SteamUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as SteamSaleApplication)
                val steamGamesListRepository = application.container.steamGamesListRepository
                SteamViewModel(steamGamesListRepository = steamGamesListRepository)
            }
        }
    }
}