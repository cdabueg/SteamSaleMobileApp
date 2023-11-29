package com.example.steamsaleapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GamesList(
    @Json(name = "apps")
    val apps: List<App>? = emptyList()
)