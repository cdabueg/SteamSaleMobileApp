package com.example.steamsaleapp.data

import com.example.steamsaleapp.model.SteamGameDetails
import com.example.steamsaleapp.network.SteamGameDetailsService

/** Repository interface to fetch Steam games list. */
interface SteamGameRepository {
    /** Fetches [SteamGameDetails] from steamAPI. */
    suspend fun getSteamGameDetails(appid: Int): SteamGameDetails
}

class NetworkSteamGameRepository(
    private val steamGameDetailsService: SteamGameDetailsService
) : SteamGameRepository {
    /** Fetches [SteamGameDetails] from steamAPI. */
    override suspend fun getSteamGameDetails(appid: Int): SteamGameDetails = steamGameDetailsService.fetchSteamGameDetails(appid)
}