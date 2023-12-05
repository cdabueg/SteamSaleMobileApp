package com.example.steamsaleapp.data

import com.example.steamsaleapp.network.SteamApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface SteamContainer {
    val steamRepository: SteamRepository
}

class DefaultSteamContainer : SteamContainer {
    private val baseUrl =
        "https://api.steampowered.com/"
//        "https://store.steampowered.com/api/"

    /** Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: SteamApiService by lazy {
        retrofit.create(SteamApiService::class.java)
    }

    override val steamRepository: SteamRepository by lazy {
        NetworkSteamRepository(retrofitService)
    }
}

// Games list: https://api.steampowered.com/ISteamApps/GetAppList/v2/
// Sample game details: https://store.steampowered.com/api/appdetails/?appids=1325200