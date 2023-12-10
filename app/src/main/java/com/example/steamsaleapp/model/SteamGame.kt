package com.example.steamsaleapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SteamGame(
    @Json(name = "1325200")
    val gameData: GameData = GameData()
) {
    @JsonClass(generateAdapter = true)
    data class GameData(
        @Json(name = "success")
        val success: Boolean? = false,
        @Json(name = "data")
        val `data`: Data = Data()
    ) {
        @JsonClass(generateAdapter = true)
        data class Data(
            @Json(name = "type")
            val type: String? = "",
            @Json(name = "name")
            val name: String? = "",
            @Json(name = "steam_appid")
            val steamAppid: Int? = 0,
            @Json(name = "required_age")
            val requiredAge: Int? = 0,
            @Json(name = "is_free")
            val isFree: Boolean? = false,
            @Json(name = "detailed_description")
            val detailedDescription: String? = "",
            @Json(name = "about_the_game")
            val aboutTheGame: String? = "",
            @Json(name = "short_description")
            val shortDescription: String? = "",
            @Json(name = "supported_languages")
            val supportedLanguages: String? = "",
            @Json(name = "reviews")
            val reviews: String? = "",
            @Json(name = "header_image")
            val headerImage: String? = "",
            @Json(name = "capsule_image")
            val capsuleImage: String? = "",
            @Json(name = "capsule_imagev5")
            val capsuleImagev5: String? = "",
            @Json(name = "website")
            val website: String? = "",
            @Json(name = "pc_requirements")
            val pcRequirements: PcRequirements? = PcRequirements(),
            @Json(name = "mac_requirements")
            val macRequirements: MacRequirements? = MacRequirements(),
            @Json(name = "linux_requirements")
            val linuxRequirements: LinuxRequirements? = LinuxRequirements(),
            @Json(name = "legal_notice")
            val legalNotice: String? = "",
            @Json(name = "developers")
            val developers: List<String?>? = listOf(),
            @Json(name = "publishers")
            val publishers: List<String?>? = listOf(),
            @Json(name = "price_overview")
            val priceOverview: PriceOverview? = PriceOverview(),
            @Json(name = "packages")
            val packages: List<Int?>? = listOf(),
            @Json(name = "package_groups")
            val packageGroups: List<PackageGroup?>? = listOf(),
            @Json(name = "platforms")
            val platforms: Platforms? = Platforms(),
            @Json(name = "metacritic")
            val metacritic: Metacritic? = Metacritic(),
            @Json(name = "categories")
            val categories: List<Category?>? = listOf(),
            @Json(name = "genres")
            val genres: List<Genre?>? = listOf(),
            @Json(name = "screenshots")
            val screenshots: List<Screenshot?>? = listOf(),
            @Json(name = "movies")
            val movies: List<Movy?>? = listOf(),
            @Json(name = "recommendations")
            val recommendations: Recommendations? = Recommendations(),
            @Json(name = "achievements")
            val achievements: Achievements? = Achievements(),
            @Json(name = "release_date")
            val releaseDate: ReleaseDate? = ReleaseDate(),
            @Json(name = "support_info")
            val supportInfo: SupportInfo? = SupportInfo(),
            @Json(name = "background")
            val background: String? = "",
            @Json(name = "background_raw")
            val backgroundRaw: String? = "",
            @Json(name = "content_descriptors")
            val contentDescriptors: ContentDescriptors? = ContentDescriptors()
        ) {
            @JsonClass(generateAdapter = true)
            data class PcRequirements(
                @Json(name = "minimum")
                val minimum: String? = "",
                @Json(name = "recommended")
                val recommended: String? = ""
            )

            @JsonClass(generateAdapter = true)
            data class MacRequirements(
                @Json(name = "minimum")
                val minimum: String? = "",
                @Json(name = "recommended")
                val recommended: String? = ""
            )

            @JsonClass(generateAdapter = true)
            data class LinuxRequirements(
                @Json(name = "minimum")
                val minimum: String? = "",
                @Json(name = "recommended")
                val recommended: String? = ""
            )

            @JsonClass(generateAdapter = true)
            data class PriceOverview(
                @Json(name = "currency")
                val currency: String? = "",
                @Json(name = "initial")
                val initial: Int? = 0,
                @Json(name = "final")
                val `final`: Int? = 0,
                @Json(name = "discount_percent")
                val discountPercent: Int? = 0,
                @Json(name = "initial_formatted")
                val initialFormatted: String? = "",
                @Json(name = "final_formatted")
                val finalFormatted: String? = ""
            )

            @JsonClass(generateAdapter = true)
            data class PackageGroup(
                @Json(name = "name")
                val name: String? = "",
                @Json(name = "title")
                val title: String? = "",
                @Json(name = "description")
                val description: String? = "",
                @Json(name = "selection_text")
                val selectionText: String? = "",
                @Json(name = "save_text")
                val saveText: String? = "",
                @Json(name = "display_type")
                val displayType: Int? = 0,
                @Json(name = "is_recurring_subscription")
                val isRecurringSubscription: String? = "",
                @Json(name = "subs")
                val subs: List<Sub?>? = listOf()
            ) {
                @JsonClass(generateAdapter = true)
                data class Sub(
                    @Json(name = "packageid")
                    val packageid: Int? = 0,
                    @Json(name = "percent_savings_text")
                    val percentSavingsText: String? = "",
                    @Json(name = "percent_savings")
                    val percentSavings: Int? = 0,
                    @Json(name = "option_text")
                    val optionText: String? = "",
                    @Json(name = "option_description")
                    val optionDescription: String? = "",
                    @Json(name = "can_get_free_license")
                    val canGetFreeLicense: String? = "",
                    @Json(name = "is_free_license")
                    val isFreeLicense: Boolean? = false,
                    @Json(name = "price_in_cents_with_discount")
                    val priceInCentsWithDiscount: Int? = 0
                )
            }

            @JsonClass(generateAdapter = true)
            data class Platforms(
                @Json(name = "windows")
                val windows: Boolean? = false,
                @Json(name = "mac")
                val mac: Boolean? = false,
                @Json(name = "linux")
                val linux: Boolean? = false
            )

            @JsonClass(generateAdapter = true)
            data class Metacritic(
                @Json(name = "score")
                val score: Int? = 0,
                @Json(name = "url")
                val url: String? = ""
            )

            @JsonClass(generateAdapter = true)
            data class Category(
                @Json(name = "id")
                val id: Int? = 0,
                @Json(name = "description")
                val description: String? = ""
            )

            @JsonClass(generateAdapter = true)
            data class Genre(
                @Json(name = "id")
                val id: String? = "",
                @Json(name = "description")
                val description: String? = ""
            )

            @JsonClass(generateAdapter = true)
            data class Screenshot(
                @Json(name = "id")
                val id: Int? = 0,
                @Json(name = "path_thumbnail")
                val pathThumbnail: String? = "",
                @Json(name = "path_full")
                val pathFull: String? = ""
            )

            @JsonClass(generateAdapter = true)
            data class Movy(
                @Json(name = "id")
                val id: Int? = 0,
                @Json(name = "name")
                val name: String? = "",
                @Json(name = "thumbnail")
                val thumbnail: String? = "",
                @Json(name = "webm")
                val webm: Webm? = Webm(),
                @Json(name = "mp4")
                val mp4: Mp4? = Mp4(),
                @Json(name = "highlight")
                val highlight: Boolean? = false
            ) {
                @JsonClass(generateAdapter = true)
                data class Webm(
                    @Json(name = "480")
                    val x480: String? = "",
                    @Json(name = "max")
                    val max: String? = ""
                )

                @JsonClass(generateAdapter = true)
                data class Mp4(
                    @Json(name = "480")
                    val x480: String? = "",
                    @Json(name = "max")
                    val max: String? = ""
                )
            }

            @JsonClass(generateAdapter = true)
            data class Recommendations(
                @Json(name = "total")
                val total: Int? = 0
            )

            @JsonClass(generateAdapter = true)
            data class Achievements(
                @Json(name = "total")
                val total: Int? = 0,
                @Json(name = "highlighted")
                val highlighted: List<Highlighted?>? = listOf()
            ) {
                @JsonClass(generateAdapter = true)
                data class Highlighted(
                    @Json(name = "name")
                    val name: String? = "",
                    @Json(name = "path")
                    val path: String? = ""
                )
            }

            @JsonClass(generateAdapter = true)
            data class ReleaseDate(
                @Json(name = "coming_soon")
                val comingSoon: Boolean? = false,
                @Json(name = "date")
                val date: String? = ""
            )

            @JsonClass(generateAdapter = true)
            data class SupportInfo(
                @Json(name = "url")
                val url: String? = "",
                @Json(name = "email")
                val email: String? = ""
            )

            @JsonClass(generateAdapter = true)
            data class ContentDescriptors(
                @Json(name = "ids")
                val ids: List<Int?>? = listOf(),
                @Json(name = "notes")
                val notes: String? = ""
            )
        }
    }
}