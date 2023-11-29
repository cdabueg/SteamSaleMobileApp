package com.example.steamsaleapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

//private const val BASE_URL =
//    "https://api.steampowered.com/"
//
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
//    .baseUrl(BASE_URL)
//    .build()
//
//
//
//object SteamApi {
//    val retrofitService : SteamService by lazy {
//        retrofit.create(SteamService::class.java)
//    }
//}