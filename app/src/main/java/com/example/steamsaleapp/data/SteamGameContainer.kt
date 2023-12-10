package com.example.steamsaleapp.data

import com.example.steamsaleapp.network.SteamGameDetailsService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface SteamGameContainer {
    val steamGameRepository: SteamGameRepository
}

class DefaultSteamGameContainer : SteamGameContainer {
    private val baseUrl =
        "https://store.steampowered.com/api/"

    private val json = Json { ignoreUnknownKeys = true }

    /** Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: SteamGameDetailsService by lazy {
        retrofit.create(SteamGameDetailsService::class.java)
    }

    override val steamGameRepository: SteamGameRepository by lazy {
        NetworkSteamGameRepository(retrofitService)
    }
}