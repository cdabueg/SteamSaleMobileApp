package com.example.steamsaleapp.API

/// This is the data class for the Steam API response
data class SteamApplistResponse(
    val applist: Applist
)

/// Makes the apps lists<App> for the Applist
data class Applist(
    val apps: List<App>
)

/// Makes the appid and name for the App
data class App(
    val appid: Int,
    val name: String
)