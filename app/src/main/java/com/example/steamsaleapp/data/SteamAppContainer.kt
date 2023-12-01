package com.example.steamsaleapp.data

import com.example.steamsaleapp.network.SteamApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface SteamAppContainer {
    val steamGamesListRepository: SteamGamesListRepository
}

class DefaultSteamAppContainer : SteamAppContainer {

    private val baseUrl =
        "https://api.steampowered.com/"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: SteamApiService by lazy {
        retrofit.create(SteamApiService::class.java)
    }

    override val steamGamesListRepository: SteamGamesListRepository by lazy {
        NetworkSteamGamesListRepository(retrofitService)
    }
}