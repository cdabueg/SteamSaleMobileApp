package com.example.steamsaleapp.viewmodel

import android.util.Log
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
import com.example.steamsaleapp.data.SteamGameRepository
import com.example.steamsaleapp.data.SteamGamesListRepository
import com.example.steamsaleapp.model.DataFiltered
import com.example.steamsaleapp.model.SteamGameDetails
import com.example.steamsaleapp.model.SteamGamesList
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
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

class MainViewModel(
    private val steamGamesListRepository: SteamGamesListRepository,
    private val steamGameRepository: SteamGameRepository
) : ViewModel(){
    private val db = Firebase.firestore
    /** The mutable State that stores the status of the most recent request */
    var steamUiState: SteamUiState by mutableStateOf(SteamUiState.Empty)
        private set
    /** The mutable State that stores the list of Steam game IDs */
    var gameIds: List<Int> by mutableStateOf(listOf())
        private set

//    /** Call getSteamGamesList() on init so we can display status immediately. */
//    init {getSteamGamesList()}

    /** Gets Steam games details from the Steam API Retrofit service */
    fun getGameDetails() {
        viewModelScope.launch {
            steamUiState = SteamUiState.Loading
            steamUiState = try {
                // Fetch the game details in a coroutine.
                SteamUiState.SuccessDetails(
//                    1325200
//                    1142710
                    steamGameRepository.getSteamGameDetails(1325200)
                )
            } catch (e: IOException) {
                SteamUiState.Error
            } catch (e: HttpException) {
                SteamUiState.Error
            }
        }
    }

    /** Update Firestore database with Steam game details */
    fun updateDb() {
        viewModelScope.launch {
            steamUiState = SteamUiState.Loading
            try {
                val numberOfGamesToUpdate = 5
                // Fetch the list of Steam games in a coroutine.
                val gameList = steamGamesListRepository.getSteamGamesList()
                // Filter out games with empty names
                val filteredGameList = gameList.applist.apps.filter { it.name.isNotEmpty() }
                val limitGameList = filteredGameList.take(numberOfGamesToUpdate)
                // Loop through the list of games
                for (app in limitGameList) {
                    Log.i("MainViewModel", "Game name: ${app.name}")
                    // Get the game details
//                    val gameDetails = steamGameRepository.getSteamGameDetails(app.appid)
//                    // Check if the game has a non-zero discount
//                    if (gameDetails.gameData.data.priceOverview?.discountPercent != 0) {
//                        val gameFilteredDetails = DataFiltered(
//                            name = gameDetails.gameData.data.name,
//                            shortDescription = gameDetails.gameData.data.shortDescription,
//                            capsuleImagev5 = gameDetails.gameData.data.capsuleImagev5,
//                            background = gameDetails.gameData.data.background,
//                            releaseDate = gameDetails.gameData.data.releaseDate,
//                            categories = gameDetails.gameData.data.categories,
//                            genres = gameDetails.gameData.data.genres,
//                            developers = gameDetails.gameData.data.developers,
//                            publishers = gameDetails.gameData.data.publishers,
//                            platforms = gameDetails.gameData.data.platforms
//                        )
//                        db.collection("games").add(gameFilteredDetails)
//                    }
                }
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
                val steamGameListRepository = application.listContainer.steamGamesListRepository
                val steamGameRepository = application.gameContainer.steamGameRepository
                MainViewModel(
                    steamGamesListRepository = steamGameListRepository,
                    steamGameRepository = steamGameRepository
                )
            }
        }
    }
}