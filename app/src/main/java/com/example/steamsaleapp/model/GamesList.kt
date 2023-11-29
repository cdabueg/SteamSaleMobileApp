package com.example.steamsaleapp.model

import kotlinx.serialization.Serializable

@Serializable
data class GamesList(
    val applist: Applist
)

@Serializable
data class Applist(
    val apps: List<App>
)

@Serializable
data class App(
    val appid: Int,
    val name: String
)