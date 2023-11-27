package com.example.steamsaleapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SteamGamePhoto(
    val id: String,
    // Changes the key
    @SerialName(value = "capsule_imagev5")
    val imgSrc: String
)