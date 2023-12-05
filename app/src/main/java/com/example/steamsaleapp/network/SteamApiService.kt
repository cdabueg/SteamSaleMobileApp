package com.example.steamsaleapp.network

import com.example.steamsaleapp.model.App
import com.example.steamsaleapp.model.SteamGamesList
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://api.steampowered.com/"

/**
 * Uses a kotlinx.serialization converter
 * Use the Retrofit builder to build a retrofit object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

/**
 * Retrofit service object for creating api calls
 */
interface SteamApiService {
    @GET("ISteamApps/GetAppList/v2/")
    suspend fun getSteamGamesList(): SteamGamesList
}

///**
// * Uses moshi converter
// * Incomplete?
// */
//object Api {
//    // Convert json to objects
//    private val moshi = Moshi.Builder()
//        .add(KotlinJsonAdapterFactory())
//        .build()
//
//    // Initialize retrofit instance
//    private val retrofit = Retrofit.Builder()
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .baseUrl(BASE_URL)
//        .build()
//
//    val retrofitService : SteamApiService by lazy {
//        retrofit.create(SteamApiService::class.java)
//    }
//}