package com.example.steamsaleapp.network

import com.example.steamsaleapp.model.SteamGame
import com.example.steamsaleapp.model.SteamGamePhoto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://api.steampowered.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface SteamApiService {
    // Http method and endpoint
    @GET("ISteamApps/GetAppList/v0002/")
//    suspend fun getSteamGames(): List<SteamGame>
    suspend fun getSteamGames(): String

    // Photos endpoint in quotes
    @GET("")
    suspend fun getGamePhotos(): List<SteamGamePhoto>
}

object SteamApi {
    val retrofitService : SteamApiService by lazy {
        retrofit.create(SteamApiService::class.java)
    }
}