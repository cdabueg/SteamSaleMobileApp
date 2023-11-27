package com.example.steamsaleapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SteamGame(
    val appid: Int,
    // Changes the key
    @SerialName(value = "name")
    val title: String
)