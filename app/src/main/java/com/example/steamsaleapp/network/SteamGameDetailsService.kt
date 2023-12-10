package com.example.steamsaleapp.network

import com.example.steamsaleapp.model.GameData
import com.example.steamsaleapp.model.SteamGameDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface SteamGameDetailsService {
    @GET("appdetails")
    suspend fun fetchSteamGameDetails(@Query("appids") appid: Int): SteamGameDetails

    @GET("appdetails")
    suspend fun fetchSteamGameHash(@Query("appids") appid: Int): HashMap<String, GameData>
}