package com.example.steamsaleapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class App(
    @Json(name = "appid")
    val appid: Int,
    @Json(name = "name")
    val name: String
)