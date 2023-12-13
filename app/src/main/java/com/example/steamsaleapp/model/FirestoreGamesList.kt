package com.example.steamsaleapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FirestoreGameslist(
    @SerialName("firestoreGames")
    var firestoreGamesList: List<FirestoreGame> = listOf()
)

@Serializable
data class FirestoreGame(
    @SerialName("gameId")
    val gameId: Long? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("final")
    val finalPrice: Long? = 0,
    @SerialName("discount_percent")
    val discountPercent: Long? = 0,
    @SerialName("short_description")
    val shortDescription: String? = "",
    @SerialName("capsule_imagev5")
    val logoUrl: String? = "",
    @SerialName("background")
    val background: String? = "",
    @SerialName("release_date")
    val releaseDate: String? = "",
    @SerialName("categories")
    val categories: List<Category?>? = listOf(),
    @SerialName("genres")
    val genres: List<Genre?>? = listOf(),
    @SerialName("developers")
    val developers: List<String?>? = listOf(),
    @SerialName("publishers")
    val publishers: List<String?>? = listOf(),
    @SerialName("platforms")
    val platforms: Platforms? = Platforms()
//    val platforms: HashMap<String, Boolean>? = hashMapOf(),
//    val platforms: String = "",
)