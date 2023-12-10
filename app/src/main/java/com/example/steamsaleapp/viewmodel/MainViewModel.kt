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
import com.google.firebase.firestore.AggregateSource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
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
                val maxGamesCount: Long = 10
                var currentGamesCount = getGamesCount()
                Log.d("updateDb", "currentGamesCount: $currentGamesCount")
                // Fetch the list of Steam games in a coroutine.
                val gameList = steamGamesListRepository.getSteamGamesList()
                // Filter out games with empty names
                val filteredGameList = gameList.applist.apps.filter { it.name.isNotEmpty() }
                // Loop through the list of games
                for (app in filteredGameList) {
                    Log.d("updateDb", "appid: ${app.appid}")
                    // Check if the maximum games count has been reached
                    if (currentGamesCount >= maxGamesCount) {
                        Log.d("updateDb", "Break because of currentGamesCount")
                        break // Exit the loop if the limit is reached
                    }
                    // Get the game details
                    val gameDetails = steamGameRepository.getSteamGameHash(app.appid)
                    // Check if the game ID exists in the database and if the game is on sale
                    if (!gameInCollection(app.appid) && gameDetails["${app.appid}"]?.data?.priceOverview?.discountPercent != 0) {
                        val gameFilteredDetails = DataFiltered(
                            gameId = app.appid,
                            name = gameDetails["${app.appid}"]?.data?.name,
                            priceOverview = gameDetails["${app.appid}"]?.data?.priceOverview,
                            shortDescription = gameDetails["${app.appid}"]?.data?.shortDescription,
                            capsuleImagev5 = gameDetails["${app.appid}"]?.data?.capsuleImagev5,
                            background = gameDetails["${app.appid}"]?.data?.background,
                            releaseDate = gameDetails["${app.appid}"]?.data?.releaseDate,
                            categories = gameDetails["${app.appid}"]?.data?.categories,
                            genres = gameDetails["${app.appid}"]?.data?.genres,
                            developers = gameDetails["${app.appid}"]?.data?.developers,
                            publishers = gameDetails["${app.appid}"]?.data?.publishers,
                            platforms = gameDetails["${app.appid}"]?.data?.platforms
                        )
                        // Add the game details to the database
                        db.collection("games").add(gameFilteredDetails)
                        // Add the game ID to the list of game IDs
                        db.collection("gameIds").add(mapOf("gameId" to app.appid))
                        // Increment the games count
                        currentGamesCount++
                    }
                }
            } catch (e: IOException) {
                SteamUiState.Error
            } catch (e: HttpException) {
                SteamUiState.Error
            }
            steamUiState = SteamUiState.Empty
        }
    }

    private suspend fun gameInCollection(gameIdToSearch: Int): Boolean {
        val firestore = FirebaseFirestore.getInstance()
        val collection = firestore.collection("gameIds")

        // Searching for the document with the given gameId
        val query = collection.whereEqualTo("gameId", gameIdToSearch)
        val result = query.get().await()

        // Checking if the result contains any documents
        Log.d("gameInCollection", "${result.documents.isNotEmpty()}")
        return result.documents.isNotEmpty()
    }

    private fun getGamesCount(): Long {
        Log.d("getGamesCount", "getGamesCount called")
        val query = db.collection("gameIds")
        val countQuery = query.count()
        var count: Long = 0
        countQuery.get(AggregateSource.SERVER).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Count fetched successfully
                count = task.result.count
            }
        }
        return count
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