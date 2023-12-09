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
import com.example.steamsaleapp.model.App
import com.example.steamsaleapp.model.DataFiltered
import com.example.steamsaleapp.model.SteamGameDetails
import com.example.steamsaleapp.model.SteamGamesList
import com.example.steamsaleapp.ui.screens.commonstates.Empty
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
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
                    steamRepository.getSteamGameDetails(1325200)
                )
            } catch (e: IOException) {
                SteamUiState.Error
            } catch (e: HttpException) {
                SteamUiState.Error
            }
        }
    }

    fun testAddToDb() {
        viewModelScope.launch {
            try {
                val gameDetails = steamRepository.getSteamGameDetails(1325200)
                val gameFilteredDetails = DataFiltered(
                    name = gameDetails.x1325200.data.name,
                    shortDescription = gameDetails.x1325200.data.shortDescription,
                    capsuleImagev5 = gameDetails.x1325200.data.capsuleImagev5,
                    background = gameDetails.x1325200.data.background,
                    releaseDate = gameDetails.x1325200.data.releaseDate,
                    categories = gameDetails.x1325200.data.categories,
                    genres = gameDetails.x1325200.data.genres,
                    developers = gameDetails.x1325200.data.developers,
                    publishers = gameDetails.x1325200.data.publishers,
                    platforms = gameDetails.x1325200.data.platforms
                )
                db.collection("games").add(gameFilteredDetails)
            } catch (e: IOException) {
                SteamUiState.Error
            } catch (e: HttpException) {
                SteamUiState.Error
            }
        }
    }



    /** Populate Firestore database with Steam game details */
    fun populateDb() {
        val gamesAddedLimit = 1
        var gamesAddedAmount = 0
        viewModelScope.launch {
            try {
                // Fetch the list of Steam games in a coroutine.
                val gameList = steamRepository.getSteamGamesList()
                // Filter out games with empty names
                val filteredApps = gameList.applist.apps.filter { it.name.isNotEmpty() }
                // Loop through the list of games
                for (app in filteredApps.takeWhile { gamesAddedAmount < gamesAddedLimit }) {
                    // Get the game details
//                    val gameDetails = steamRepository.getSteamGameDetails(app.appid)
                    val gameDetails = steamRepository.getSteamGameDetails(1325200)
                    // Check if the game has a non-zero discount
                    if (gameDetails.x1325200.data.priceOverview?.discountPercent != 0) {
                        val gameFilteredDetails = DataFiltered(
                            name = gameDetails.x1325200.data.name,
                            shortDescription = gameDetails.x1325200.data.shortDescription,
                            capsuleImagev5 = gameDetails.x1325200.data.capsuleImagev5,
                            background = gameDetails.x1325200.data.background,
                            releaseDate = gameDetails.x1325200.data.releaseDate,
                            categories = gameDetails.x1325200.data.categories,
                            genres = gameDetails.x1325200.data.genres,
                            developers = gameDetails.x1325200.data.developers,
                            publishers = gameDetails.x1325200.data.publishers,
                            platforms = gameDetails.x1325200.data.platforms
                        )
                        db.collection("games").add(gameFilteredDetails)
                        gamesAddedAmount++
                    }
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
                val steamRepository = application.container.steamRepository
                SteamViewModel(steamRepository = steamRepository)
            }
        }
    }
}