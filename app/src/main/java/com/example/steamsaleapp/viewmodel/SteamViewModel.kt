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
import com.example.steamsaleapp.data.SteamRepository
import com.example.steamsaleapp.model.SteamGameDetails
import com.example.steamsaleapp.model.SteamGamesList
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/** UI state for the SteamMainContent screen */
sealed interface SteamUiState {
    // Requires primary constructor parameter. val gamesList
    data class SuccessList(val gamesList: SteamGamesList) : SteamUiState
    data class SuccessDetails(val gamesDetails: SteamGameDetails) : SteamUiState
    object Error : SteamUiState
    object Loading : SteamUiState
    object Empty : SteamUiState
}

class SteamViewModel(private val steamRepository: SteamRepository) : ViewModel(){
    /** The mutable State that stores the status of the most recent request */
    var steamUiState: SteamUiState by mutableStateOf(SteamUiState.Empty)
        private set

//    /** Call getSteamGamesList() on init so we can display status immediately. */
//    init {getSteamGamesList()}

    /** Gets Steam games list from the Steam API Retrofit service */
    fun getSteamGamesList() {
        viewModelScope.launch {
            steamUiState = SteamUiState.Loading
            steamUiState = try {
                // Fetch the list of Steam games in a coroutine.
                SteamUiState.SuccessList(
                    steamRepository.getSteamGamesList()
                )
            } catch (e: IOException) {
                SteamUiState.Error
            } catch (e: HttpException) {
                SteamUiState.Error
            }
        }
    }

    /** Gets Steam games details from the Steam API Retrofit service */
    fun getGameDetails() {
        viewModelScope.launch {
            steamUiState = SteamUiState.Loading
            steamUiState = try {
                // Fetch the game details in a coroutine.
                SteamUiState.SuccessDetails(
                    steamRepository.getSteamGameDetails(1325200)
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
                val steamRepository = application.container.steamRepository
                SteamViewModel(steamRepository = steamRepository)
            }
        }
    }
}