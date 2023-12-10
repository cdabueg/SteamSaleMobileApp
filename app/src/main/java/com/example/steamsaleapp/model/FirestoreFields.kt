package com.example.steamsaleapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FirestoreFields(
    @SerialName("gameId")
    val gameId: Int? = 0,
)

@Serializable
data class GameId(
    @SerialName("gameId")
    val gameId: Int? = 0,
)

@Serializable
data class DataFiltered(
    @SerialName("gameId")
    val gameId: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("price_overview")
    val priceOverview: PriceOverview? = PriceOverview(),
    @SerialName("short_description")
    val shortDescription: String? = "",
    @SerialName("capsule_imagev5")
    val capsuleImagev5: String? = "",
    @SerialName("background")
    val background: String? = "",
    @SerialName("release_date")
    val releaseDate: ReleaseDate? = ReleaseDate(),
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
)
