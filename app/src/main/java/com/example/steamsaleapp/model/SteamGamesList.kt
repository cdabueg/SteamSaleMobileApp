package com.example.steamsaleapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** [SteamGamesList] using kotlinx.serialization */
@Serializable
data class SteamGamesList(
    @SerialName("applist")
    val applist: Applist
)

@Serializable
data class Applist(
    @SerialName("apps")
    val apps: List<App>
)

@Serializable
data class App(
    @SerialName("appid")
    val appid: Int,
    @SerialName("name")
    val name: String
)

///** Using moshi */
//@JsonClass(generateAdapter = true)
//data class SteamGamesList(
//    @Json(name = "applist")
//    val applist: Applist
//)
//
//@JsonClass(generateAdapter = true)
//data class Applist(
//    @Json(name = "apps")
//    val apps: List<App>
//)
//
//@JsonClass(generateAdapter = true)
//data class App(
//    @Json(name = "appid")
//    val appid: Int,
//    @Json(name = "name")
//    val name: String
//)

