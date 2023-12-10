package com.example.steamsaleapp.network

import com.example.steamsaleapp.model.SteamGamesList
import retrofit2.http.GET

interface SteamGamesListService {
    @GET("ISteamApps/GetAppList/v2/")
    suspend fun fetchSteamGamesList(): SteamGamesList
}