package com.example.steamsaleapp.data

import com.example.steamsaleapp.model.SteamGamesList
import com.example.steamsaleapp.network.SteamGamesListService

/** Repository interface to fetch Steam games list. */
interface SteamGamesListRepository {
    /** Fetches list of [SteamGamesList] from steamAPI. */
    suspend fun getSteamGamesList(): SteamGamesList
}

class NetworkSteamGamesListRepository(
    private val steamGamesListService: SteamGamesListService
) : SteamGamesListRepository {
    /** Fetches list of [SteamGamesList] from steamAPI. */
    override suspend fun getSteamGamesList(): SteamGamesList = steamGamesListService.fetchSteamGamesList()
}