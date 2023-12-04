package com.example.steamsaleapp.data

import com.example.steamsaleapp.model.App
import com.example.steamsaleapp.model.SteamGamesList
import com.example.steamsaleapp.network.SteamApiService

/**
 * Repository interface to fetch Steam games list.
 */
interface SteamGamesListRepository {
    /** Fetches list of [SteamGamesList] from steamAPI. */
    suspend fun getSteamGamesList(): SteamGamesList
}

class NetworkSteamGamesListRepository(
    private val steamApiService: SteamApiService
) : SteamGamesListRepository {
    /** Fetches list of [SteamGamesList] from steamAPI. */
    override suspend fun getSteamGamesList(): SteamGamesList = steamApiService.getSteamGamesList()
}