package com.example.steamsaleapp.data

import com.example.steamsaleapp.model.SteamGameDetails
import com.example.steamsaleapp.model.SteamGamesList
import com.example.steamsaleapp.network.SteamApiService

/** Repository interface to fetch Steam games list. */
interface SteamRepository {
    /** Fetches list of [SteamGamesList] from steamAPI. */
    suspend fun getSteamGamesList(): SteamGamesList

    /** Fetches [SteamGameDetails] from steamAPI. */
    suspend fun getSteamGameDetails(appid: Int): SteamGameDetails
}

class NetworkSteamRepository(
    private val steamApiService: SteamApiService
) : SteamRepository {
    /** Fetches list of [SteamGamesList] from steamAPI. */
    override suspend fun getSteamGamesList(): SteamGamesList = steamApiService.fetchSteamGamesList()

    /** Fetches [SteamGameDetails] from steamAPI. */
    override suspend fun getSteamGameDetails(appid: Int): SteamGameDetails = steamApiService.fetchSteamGameDetails(appid)
}