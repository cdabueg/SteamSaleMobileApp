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
                db.collection("games").add(gameDetails.x1325200.data)
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
                        // Parse the game details
//                        val gameMap = parseGameData(gameDetails.toString())

                        // Add the game details to the database
                        db.collection("games").add(gameDetails.x1325200.data)
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

//    fun parseGameData(gameData: String): HashMap<String, Any> {
//        val json = Json { ignoreUnknownKeys = true }
//        val gameMap = HashMap<String, Any>()
//
//        // Parse JSON and extract required fields
//        val jsonObject = json.decodeFromString<JsonObject>(gameData)
//        val data = jsonObject["1325200"]?.jsonObject?.get("data")?.jsonObject
//
//        if (data != null) {
//            gameMap["name"] = data["name"]?.jsonPrimitive?.contentOrNull ?: ""
//            gameMap["shortDescription"] = data["short_description"]?.jsonPrimitive?.contentOrNull ?: ""
//            gameMap["capsuleImagev5"] = data["capsule_imagev5"]?.jsonPrimitive?.contentOrNull ?: ""
//            gameMap["background"] = data["background"]?.jsonPrimitive?.contentOrNull ?: ""
//            gameMap["releaseDate"] = data["release_date"]?.jsonObject?.get("date")?.jsonPrimitive?.contentOrNull ?: ""
//            gameMap["categories"] = data["categories"]?.jsonArray?.map { it.jsonObject["description"]?.jsonPrimitive?.contentOrNull }
//            gameMap["genres"] = data["genres"]?.jsonArray?.map { it.jsonObject["description"]?.jsonPrimitive?.contentOrNull }
//            gameMap["developers"] = data["developers"]?.jsonArray?.map { it.jsonPrimitive?.contentOrNull }
//            gameMap["publishers"] = data["publishers"]?.jsonArray?.map { it.jsonPrimitive?.contentOrNull }
//            gameMap["platforms"] = data["platforms"]?.jsonObject?.toMap()
//
//            // Add more fields as needed
//        }
//
//        return gameMap
//    }

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