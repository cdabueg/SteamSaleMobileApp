package com.example.steamsaleapp.network

import com.example.steamsaleapp.model.GamesList
import retrofit2.Call
import retrofit2.http.GET

interface SteamService {
    // Http method and endpoint
    @GET("ISteamApps/GetAppList/v0002/?format=json")
    fun getSteamGames(): Call<GamesList>
}