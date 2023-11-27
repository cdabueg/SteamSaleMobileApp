package com.example.steamsaleapp.model

import kotlinx.serialization.Serializable

@Serializable
data class SteamGame(
    val applist: Applist
)

@Serializable
data class Applist(
    val apps: ArrayList<App>
)

@Serializable
data class App(
    val appid: Int,
    val name: String = ""
)