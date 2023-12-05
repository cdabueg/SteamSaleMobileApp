package com.example.steamsaleapp.network

import com.example.steamsaleapp.model.SteamGameDetails
import com.example.steamsaleapp.model.SteamGamesList
import retrofit2.http.GET
import retrofit2.http.Query

/** Retrofit service object for creating api calls */
interface SteamApiService {
    @GET("ISteamApps/GetAppList/v2/")
    suspend fun fetchSteamGamesList(): SteamGamesList

    @GET("appdetails")
    suspend fun fetchSteamGameDetails(@Query("appids") appid: Int): SteamGameDetails
}

// Games list: https://api.steampowered.com/ISteamApps/GetAppList/v2/
// Sample game details: https://store.steampowered.com/api/appdetails/?appids=1325200