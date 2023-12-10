package com.example.steamsaleapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

// TODO: Make @SerialName("1325200") dynamic
@Serializable
data class SteamGameDetails(
    @SerialName("1325200")
//    @SerialName("gameId")
    val gameData: GameData = GameData()
)

@Serializable
data class GameData(
    @SerialName("success")
    val success: Boolean? = false,
    @SerialName("data")
    val `data`: Data = Data()
)

@Serializable
data class Data(
    @SerialName("type")
    val type: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("steam_appid")
    val steamAppid: Int? = 0,
    @SerialName("required_age")
    val requiredAge: Int? = 0,
    @SerialName("is_free")
    val isFree: Boolean? = false,
    @SerialName("detailed_description")
    val detailedDescription: String? = "",
    @SerialName("about_the_game")
    val aboutTheGame: String? = "",
    @SerialName("short_description")
    val shortDescription: String? = "",
    @SerialName("supported_languages")
    val supportedLanguages: String? = "",
    @SerialName("reviews")
    val reviews: String? = "",
    @SerialName("header_image")
    val headerImage: String? = "",
    @SerialName("capsule_image")
    val capsuleImage: String? = "",
    @SerialName("capsule_imagev5")
    val capsuleImagev5: String? = "",
    @SerialName("website")
    val website: String? = "",
    @SerialName("pc_requirements")
//    val pcRequirements: PcRequirements? = PcRequirements(),
    val pcRequirements: JsonElement? = null,
    @SerialName("mac_requirements")
//    val macRequirements: MacRequirements? = MacRequirements(),
    val macRequirements: JsonElement? = null,
    @SerialName("linux_requirements")
//    val linuxRequirements: LinuxRequirements? = LinuxRequirements(),
    val linuxRequirements: JsonElement? = null,
    @SerialName("legal_notice")
    val legalNotice: String? = "",
    @SerialName("developers")
    val developers: List<String?>? = listOf(),
    @SerialName("publishers")
    val publishers: List<String?>? = listOf(),
    @SerialName("price_overview")
    val priceOverview: PriceOverview? = PriceOverview(),
    @SerialName("packages")
    val packages: List<Int?>? = listOf(),
    @SerialName("package_groups")
    val packageGroups: List<PackageGroup?>? = listOf(),
    @SerialName("platforms")
    val platforms: Platforms? = Platforms(),
    @SerialName("metacritic")
    val metacritic: Metacritic? = Metacritic(),
    @SerialName("categories")
    val categories: List<Category?>? = listOf(),
    @SerialName("genres")
    val genres: List<Genre?>? = listOf(),
    @SerialName("screenshots")
    val screenshots: List<Screenshot?>? = listOf(),
    @SerialName("movies")
    val movies: List<Movy?>? = listOf(),
    @SerialName("recommendations")
    val recommendations: Recommendations? = Recommendations(),
    @SerialName("achievements")
    val achievements: Achievements? = Achievements(),
    @SerialName("release_date")
    val releaseDate: ReleaseDate? = ReleaseDate(),
    @SerialName("support_info")
    val supportInfo: SupportInfo? = SupportInfo(),
    @SerialName("background")
    val background: String? = "",
    @SerialName("background_raw")
    val backgroundRaw: String? = "",
    @SerialName("content_descriptors")
    val contentDescriptors: ContentDescriptors? = ContentDescriptors()
)

@Serializable
data class PcRequirements(
    @SerialName("minimum")
    val minimum: String? = "",
    @SerialName("recommended")
    val recommended: String? = ""
)

@Serializable
data class MacRequirements(
    @SerialName("minimum")
    val minimum: String? = "",
    @SerialName("recommended")
    val recommended: String? = ""
)

@Serializable
data class LinuxRequirements(
    @SerialName("minimum")
    val minimum: String? = "",
    @SerialName("recommended")
    val recommended: String? = ""
)

@Serializable
data class PriceOverview(
    @SerialName("currency")
    val currency: String? = "",
    @SerialName("initial")
    val initial: Int? = 0,
    @SerialName("final")
    val `final`: Int? = 0,
    @SerialName("discount_percent")
    val discountPercent: Int? = 0,
    @SerialName("initial_formatted")
    val initialFormatted: String? = "",
    @SerialName("final_formatted")
    val finalFormatted: String? = ""
)

@Serializable
data class PackageGroup(
    @SerialName("name")
    val name: String? = "",
    @SerialName("title")
    val title: String? = "",
    @SerialName("description")
    val description: String? = "",
    @SerialName("selection_text")
    val selectionText: String? = "",
    @SerialName("save_text")
    val saveText: String? = "",
    @SerialName("display_type")
    val displayType: Int? = 0,
    @SerialName("is_recurring_subscription")
    val isRecurringSubscription: String? = "",
    @SerialName("subs")
    val subs: List<Sub?>? = listOf()
)

@Serializable
data class Sub(
    @SerialName("packageid")
    val packageid: Int? = 0,
    @SerialName("percent_savings_text")
    val percentSavingsText: String? = "",
    @SerialName("percent_savings")
    val percentSavings: Int? = 0,
    @SerialName("option_text")
    val optionText: String? = "",
    @SerialName("option_description")
    val optionDescription: String? = "",
    @SerialName("can_get_free_license")
    val canGetFreeLicense: String? = "",
    @SerialName("is_free_license")
    val isFreeLicense: Boolean? = false,
    @SerialName("price_in_cents_with_discount")
    val priceInCentsWithDiscount: Int? = 0
)

@Serializable
data class Platforms(
    @SerialName("windows")
    val windows: Boolean? = false,
    @SerialName("mac")
    val mac: Boolean? = false,
    @SerialName("linux")
    val linux: Boolean? = false
)

@Serializable
data class Metacritic(
    @SerialName("score")
    val score: Int? = 0,
    @SerialName("url")
    val url: String? = ""
)

@Serializable
data class Category(
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("description")
    val description: String? = ""
)

@Serializable
data class Genre(
    @SerialName("id")
    val id: String? = "",
    @SerialName("description")
    val description: String? = ""
)

@Serializable
data class Screenshot(
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("path_thumbnail")
    val pathThumbnail: String? = "",
    @SerialName("path_full")
    val pathFull: String? = ""
)

@Serializable
data class Movy(
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("thumbnail")
    val thumbnail: String? = "",
    @SerialName("webm")
    val webm: Webm? = Webm(),
    @SerialName("mp4")
    val mp4: Mp4? = Mp4(),
    @SerialName("highlight")
    val highlight: Boolean? = false
)

@Serializable
data class Webm(
    @SerialName("480")
    val x480: String? = "",
    @SerialName("max")
    val max: String? = ""
)

@Serializable
data class Mp4(
    @SerialName("480")
    val x480: String? = "",
    @SerialName("max")
    val max: String? = ""
)

@Serializable
data class Recommendations(
    @SerialName("total")
    val total: Int? = 0
)

@Serializable
data class Achievements(
    @SerialName("total")
    val total: Int? = 0,
    @SerialName("highlighted")
    val highlighted: List<Highlighted?>? = listOf()
)

@Serializable
data class Highlighted(
    @SerialName("name")
    val name: String? = "",
    @SerialName("path")
    val path: String? = ""
)

@Serializable
data class ReleaseDate(
    @SerialName("coming_soon")
    val comingSoon: Boolean? = false,
    @SerialName("date")
    val date: String? = ""
)

@Serializable
data class SupportInfo(
    @SerialName("url")
    val url: String? = "",
    @SerialName("email")
    val email: String? = ""
)

@Serializable
data class ContentDescriptors(
    @SerialName("ids")
    val ids: List<Int?>? = listOf(),
    @SerialName("notes")
    val notes: String? = ""
)


//// Using Moshi
//@JsonClass(generateAdapter = true)
//data class DataFiltered(
//    val name: String? = "",
//    @Json(name = "short_description")
//    val shortDescription: String? = "",
//    @Json(name = "capsule_imagev5")
//    val capsuleImagev5: String? = "",
//    val background: String? = "",
//    @Json(name = "release_date")
//    val releaseDate: ReleaseDate? = ReleaseDate(),
//    val categories: List<Category?>? = listOf(),
//    val genres: List<Genre?>? = listOf(),
//    val developers: List<String?>? = listOf(),
//    val publishers: List<String?>? = listOf(),
//    val platforms: Platforms? = Platforms()
//)
//
//@JsonClass(generateAdapter = true)
//data class SteamGameDetails(
////    @Json(name = "1325200")
////    val gameData: GameData = GameData()
//    @Json(name = "1325200")
//    val x1325200: SteamGame.X1325200? = SteamGame.X1325200()
//)
//
//@JsonClass(generateAdapter = true)
//data class GameData(
////data class X1325200(
//    @Json(name = "success")
//    val success: Boolean? = false,
//    @Json(name = "data")
//    val `data`: Data = Data()
//)
//
//@JsonClass(generateAdapter = true)
//data class Data(
//    @Json(name = "type")
//    val type: String? = "",
//    @Json(name = "name")
//    val name: String? = "",
//    @Json(name = "steam_appid")
//    val steamAppid: Int? = 0,
//    @Json(name = "required_age")
//    val requiredAge: Int? = 0,
//    @Json(name = "is_free")
//    val isFree: Boolean? = false,
//    @Json(name = "detailed_description")
//    val detailedDescription: String? = "",
//    @Json(name = "about_the_game")
//    val aboutTheGame: String? = "",
//    @Json(name = "short_description")
//    val shortDescription: String? = "",
//    @Json(name = "supported_languages")
//    val supportedLanguages: String? = "",
//    @Json(name = "reviews")
//    val reviews: String? = "",
//    @Json(name = "header_image")
//    val headerImage: String? = "",
//    @Json(name = "capsule_image")
//    val capsuleImage: String? = "",
//    @Json(name = "capsule_imagev5")
//    val capsuleImagev5: String? = "",
//    @Json(name = "website")
//    val website: String? = "",
//    @Json(name = "pc_requirements")
//    val pcRequirements: PcRequirements? = PcRequirements(),
//    @Json(name = "mac_requirements")
//    val macRequirements: MacRequirements? = MacRequirements(),
//    @Json(name = "linux_requirements")
//    val linuxRequirements: LinuxRequirements? = LinuxRequirements(),
//    @Json(name = "legal_notice")
//    val legalNotice: String? = "",
//    @Json(name = "developers")
//    val developers: List<String?>? = listOf(),
//    @Json(name = "publishers")
//    val publishers: List<String?>? = listOf(),
//    @Json(name = "price_overview")
//    val priceOverview: PriceOverview? = PriceOverview(),
//    @Json(name = "packages")
//    val packages: List<Int?>? = listOf(),
//    @Json(name = "package_groups")
//    val packageGroups: List<PackageGroup?>? = listOf(),
//    @Json(name = "platforms")
//    val platforms: Platforms? = Platforms(),
//    @Json(name = "metacritic")
//    val metacritic: Metacritic? = Metacritic(),
//    @Json(name = "categories")
//    val categories: List<Category?>? = listOf(),
//    @Json(name = "genres")
//    val genres: List<Genre?>? = listOf(),
//    @Json(name = "screenshots")
//    val screenshots: List<Screenshot?>? = listOf(),
//    @Json(name = "movies")
//    val movies: List<Movy?>? = listOf(),
//    @Json(name = "recommendations")
//    val recommendations: Recommendations? = Recommendations(),
//    @Json(name = "achievements")
//    val achievements: Achievements? = Achievements(),
//    @Json(name = "release_date")
//    val releaseDate: ReleaseDate? = ReleaseDate(),
//    @Json(name = "support_info")
//    val supportInfo: SupportInfo? = SupportInfo(),
//    @Json(name = "background")
//    val background: String? = "",
//    @Json(name = "background_raw")
//    val backgroundRaw: String? = "",
//    @Json(name = "content_descriptors")
//    val contentDescriptors: ContentDescriptors? = ContentDescriptors()
//)
//@JsonClass(generateAdapter = true)
//data class PcRequirements(
//    @Json(name = "minimum")
//    val minimum: String? = "",
//    @Json(name = "recommended")
//    val recommended: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class MacRequirements(
//    @Json(name = "minimum")
//    val minimum: String? = "",
//    @Json(name = "recommended")
//    val recommended: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class LinuxRequirements(
//    @Json(name = "minimum")
//    val minimum: String? = "",
//    @Json(name = "recommended")
//    val recommended: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class PriceOverview(
//    @Json(name = "currency")
//    val currency: String? = "",
//    @Json(name = "initial")
//    val initial: Int? = 0,
//    @Json(name = "final")
//    val `final`: Int? = 0,
//    @Json(name = "discount_percent")
//    val discountPercent: Int? = 0,
//    @Json(name = "initial_formatted")
//    val initialFormatted: String? = "",
//    @Json(name = "final_formatted")
//    val finalFormatted: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class PackageGroup(
//    @Json(name = "name")
//    val name: String? = "",
//    @Json(name = "title")
//    val title: String? = "",
//    @Json(name = "description")
//    val description: String? = "",
//    @Json(name = "selection_text")
//    val selectionText: String? = "",
//    @Json(name = "save_text")
//    val saveText: String? = "",
//    @Json(name = "display_type")
//    val displayType: Int? = 0,
//    @Json(name = "is_recurring_subscription")
//    val isRecurringSubscription: String? = "",
//    @Json(name = "subs")
//    val subs: List<Sub?>? = listOf()
//)
//
//@JsonClass(generateAdapter = true)
//data class Sub(
//    @Json(name = "packageid")
//    val packageid: Int? = 0,
//    @Json(name = "percent_savings_text")
//    val percentSavingsText: String? = "",
//    @Json(name = "percent_savings")
//    val percentSavings: Int? = 0,
//    @Json(name = "option_text")
//    val optionText: String? = "",
//    @Json(name = "option_description")
//    val optionDescription: String? = "",
//    @Json(name = "can_get_free_license")
//    val canGetFreeLicense: String? = "",
//    @Json(name = "is_free_license")
//    val isFreeLicense: Boolean? = false,
//    @Json(name = "price_in_cents_with_discount")
//    val priceInCentsWithDiscount: Int? = 0
//)
//
//@JsonClass(generateAdapter = true)
//data class Platforms(
//    @Json(name = "windows")
//    val windows: Boolean? = false,
//    @Json(name = "mac")
//    val mac: Boolean? = false,
//    @Json(name = "linux")
//    val linux: Boolean? = false
//)
//
//@JsonClass(generateAdapter = true)
//data class Metacritic(
//    @Json(name = "score")
//    val score: Int? = 0,
//    @Json(name = "url")
//    val url: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class Category(
//    @Json(name = "id")
//    val id: Int? = 0,
//    @Json(name = "description")
//    val description: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class Genre(
//    @Json(name = "id")
//    val id: String? = "",
//    @Json(name = "description")
//    val description: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class Screenshot(
//    @Json(name = "id")
//    val id: Int? = 0,
//    @Json(name = "path_thumbnail")
//    val pathThumbnail: String? = "",
//    @Json(name = "path_full")
//    val pathFull: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class Movy(
//    @Json(name = "id")
//    val id: Int? = 0,
//    @Json(name = "name")
//    val name: String? = "",
//    @Json(name = "thumbnail")
//    val thumbnail: String? = "",
//    @Json(name = "webm")
//    val webm: Webm? = Webm(),
//    @Json(name = "mp4")
//    val mp4: Mp4? = Mp4(),
//    @Json(name = "highlight")
//    val highlight: Boolean? = false
//)
//
//@JsonClass(generateAdapter = true)
//data class Webm(
//    @Json(name = "480")
//    val x480: String? = "",
//    @Json(name = "max")
//    val max: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class Mp4(
//    @Json(name = "480")
//    val x480: String? = "",
//    @Json(name = "max")
//    val max: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class Recommendations(
//    @Json(name = "total")
//    val total: Int? = 0
//)
//
//@JsonClass(generateAdapter = true)
//data class Achievements(
//    @Json(name = "total")
//    val total: Int? = 0,
//    @Json(name = "highlighted")
//    val highlighted: List<Highlighted?>? = listOf()
//)
//
//@JsonClass(generateAdapter = true)
//data class Highlighted(
//    @Json(name = "name")
//    val name: String? = "",
//    @Json(name = "path")
//    val path: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class ReleaseDate(
//    @Json(name = "coming_soon")
//    val comingSoon: Boolean? = false,
//    @Json(name = "date")
//    val date: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class SupportInfo(
//    @Json(name = "url")
//    val url: String? = "",
//    @Json(name = "email")
//    val email: String? = ""
//)
//
//@JsonClass(generateAdapter = true)
//data class ContentDescriptors(
//    @Json(name = "ids")
//    val ids: List<Int?>? = listOf(),
//    @Json(name = "notes")
//    val notes: String? = ""
//)