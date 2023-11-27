package com.example.steamsaleapp.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://api.steampowered.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface SteamApiService {
    // Http method and endpoint
    @GET("ISteamApps/GetAppList/v0002/")
    suspend fun getSteamApps(): String
}

object SteamApi {
    val retrofitService : SteamApiService by lazy {
        retrofit.create(SteamApiService::class.java)
    }
}