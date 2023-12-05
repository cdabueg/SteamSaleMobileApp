package com.example.steamsaleapp.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SteamGameDetails(
    @SerialName("1325200")
    val x1325200: X1325200 = X1325200()
//    @SerialName("id")
//    var id: Int? = 0,
)

@Serializable
data class X1325200(
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
    val requiredAge: String? = "",
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
    val pcRequirements: PcRequirements? = PcRequirements(),
    @SerialName("mac_requirements")
    val macRequirements: MacRequirements? = MacRequirements(),
    @SerialName("linux_requirements")
    val linuxRequirements: LinuxRequirements? = LinuxRequirements(),
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

//// Inner class model
//@Serializable
//data class SteamGameDetails(
//    @SerialName("1325200")
//    val x1325200: X1325200? = X1325200()
////    @SerialName("id")
////    var id: Int? = 0,
//) {
//    @Serializable
//    data class X1325200(
//        @SerialName("success")
//        val success: Boolean? = false,
//        @SerialName("data")
//        val `data`: Data? = Data()
//    ) {
//        @Serializable
//        data class Data(
//            @SerialName("type")
//            val type: String? = "",
//            @SerialName("name")
//            val name: String? = "",
//            @SerialName("steam_appid")
//            val steamAppid: Int? = 0,
//            @SerialName("required_age")
//            val requiredAge: String? = "",
//            @SerialName("is_free")
//            val isFree: Boolean? = false,
//            @SerialName("detailed_description")
//            val detailedDescription: String? = "",
//            @SerialName("about_the_game")
//            val aboutTheGame: String? = "",
//            @SerialName("short_description")
//            val shortDescription: String? = "",
//            @SerialName("supported_languages")
//            val supportedLanguages: String? = "",
//            @SerialName("reviews")
//            val reviews: String? = "",
//            @SerialName("header_image")
//            val headerImage: String? = "",
//            @SerialName("capsule_image")
//            val capsuleImage: String? = "",
//            @SerialName("capsule_imagev5")
//            val capsuleImagev5: String? = "",
//            @SerialName("website")
//            val website: String? = "",
//            @SerialName("pc_requirements")
//            val pcRequirements: PcRequirements? = PcRequirements(),
//            @SerialName("mac_requirements")
//            val macRequirements: MacRequirements? = MacRequirements(),
//            @SerialName("linux_requirements")
//            val linuxRequirements: LinuxRequirements? = LinuxRequirements(),
//            @SerialName("legal_notice")
//            val legalNotice: String? = "",
//            @SerialName("developers")
//            val developers: List<String?>? = listOf(),
//            @SerialName("publishers")
//            val publishers: List<String?>? = listOf(),
//            @SerialName("price_overview")
//            val priceOverview: PriceOverview? = PriceOverview(),
//            @SerialName("packages")
//            val packages: List<Int?>? = listOf(),
//            @SerialName("package_groups")
//            val packageGroups: List<PackageGroup?>? = listOf(),
//            @SerialName("platforms")
//            val platforms: Platforms? = Platforms(),
//            @SerialName("metacritic")
//            val metacritic: Metacritic? = Metacritic(),
//            @SerialName("categories")
//            val categories: List<Category?>? = listOf(),
//            @SerialName("genres")
//            val genres: List<Genre?>? = listOf(),
//            @SerialName("screenshots")
//            val screenshots: List<Screenshot?>? = listOf(),
//            @SerialName("movies")
//            val movies: List<Movy?>? = listOf(),
//            @SerialName("recommendations")
//            val recommendations: Recommendations? = Recommendations(),
//            @SerialName("achievements")
//            val achievements: Achievements? = Achievements(),
//            @SerialName("release_date")
//            val releaseDate: ReleaseDate? = ReleaseDate(),
//            @SerialName("support_info")
//            val supportInfo: SupportInfo? = SupportInfo(),
//            @SerialName("background")
//            val background: String? = "",
//            @SerialName("background_raw")
//            val backgroundRaw: String? = "",
//            @SerialName("content_descriptors")
//            val contentDescriptors: ContentDescriptors? = ContentDescriptors()
//        ) {
//            @Serializable
//            data class PcRequirements(
//                @SerialName("minimum")
//                val minimum: String? = "",
//                @SerialName("recommended")
//                val recommended: String? = ""
//            )
//
//            @Serializable
//            data class MacRequirements(
//                @SerialName("minimum")
//                val minimum: String? = "",
//                @SerialName("recommended")
//                val recommended: String? = ""
//            )
//
//            @Serializable
//            data class LinuxRequirements(
//                @SerialName("minimum")
//                val minimum: String? = "",
//                @SerialName("recommended")
//                val recommended: String? = ""
//            )
//
//            @Serializable
//            data class PriceOverview(
//                @SerialName("currency")
//                val currency: String? = "",
//                @SerialName("initial")
//                val initial: Int? = 0,
//                @SerialName("final")
//                val `final`: Int? = 0,
//                @SerialName("discount_percent")
//                val discountPercent: Int? = 0,
//                @SerialName("initial_formatted")
//                val initialFormatted: String? = "",
//                @SerialName("final_formatted")
//                val finalFormatted: String? = ""
//            )
//
//            @Serializable
//            data class PackageGroup(
//                @SerialName("name")
//                val name: String? = "",
//                @SerialName("title")
//                val title: String? = "",
//                @SerialName("description")
//                val description: String? = "",
//                @SerialName("selection_text")
//                val selectionText: String? = "",
//                @SerialName("save_text")
//                val saveText: String? = "",
//                @SerialName("display_type")
//                val displayType: Int? = 0,
//                @SerialName("is_recurring_subscription")
//                val isRecurringSubscription: String? = "",
//                @SerialName("subs")
//                val subs: List<Sub?>? = listOf()
//            ) {
//                @Serializable
//                data class Sub(
//                    @SerialName("packageid")
//                    val packageid: Int? = 0,
//                    @SerialName("percent_savings_text")
//                    val percentSavingsText: String? = "",
//                    @SerialName("percent_savings")
//                    val percentSavings: Int? = 0,
//                    @SerialName("option_text")
//                    val optionText: String? = "",
//                    @SerialName("option_description")
//                    val optionDescription: String? = "",
//                    @SerialName("can_get_free_license")
//                    val canGetFreeLicense: String? = "",
//                    @SerialName("is_free_license")
//                    val isFreeLicense: Boolean? = false,
//                    @SerialName("price_in_cents_with_discount")
//                    val priceInCentsWithDiscount: Int? = 0
//                )
//            }
//
//            @Serializable
//            data class Platforms(
//                @SerialName("windows")
//                val windows: Boolean? = false,
//                @SerialName("mac")
//                val mac: Boolean? = false,
//                @SerialName("linux")
//                val linux: Boolean? = false
//            )
//
//            @Serializable
//            data class Metacritic(
//                @SerialName("score")
//                val score: Int? = 0,
//                @SerialName("url")
//                val url: String? = ""
//            )
//
//            @Serializable
//            data class Category(
//                @SerialName("id")
//                val id: Int? = 0,
//                @SerialName("description")
//                val description: String? = ""
//            )
//
//            @Serializable
//            data class Genre(
//                @SerialName("id")
//                val id: String? = "",
//                @SerialName("description")
//                val description: String? = ""
//            )
//
//            @Serializable
//            data class Screenshot(
//                @SerialName("id")
//                val id: Int? = 0,
//                @SerialName("path_thumbnail")
//                val pathThumbnail: String? = "",
//                @SerialName("path_full")
//                val pathFull: String? = ""
//            )
//
//            @Serializable
//            data class Movy(
//                @SerialName("id")
//                val id: Int? = 0,
//                @SerialName("name")
//                val name: String? = "",
//                @SerialName("thumbnail")
//                val thumbnail: String? = "",
//                @SerialName("webm")
//                val webm: Webm? = Webm(),
//                @SerialName("mp4")
//                val mp4: Mp4? = Mp4(),
//                @SerialName("highlight")
//                val highlight: Boolean? = false
//            ) {
//                @Serializable
//                data class Webm(
//                    @SerialName("480")
//                    val x480: String? = "",
//                    @SerialName("max")
//                    val max: String? = ""
//                )
//
//                @Serializable
//                data class Mp4(
//                    @SerialName("480")
//                    val x480: String? = "",
//                    @SerialName("max")
//                    val max: String? = ""
//                )
//            }
//
//            @Serializable
//            data class Recommendations(
//                @SerialName("total")
//                val total: Int? = 0
//            )
//
//            @Serializable
//            data class Achievements(
//                @SerialName("total")
//                val total: Int? = 0,
//                @SerialName("highlighted")
//                val highlighted: List<Highlighted?>? = listOf()
//            ) {
//                @Serializable
//                data class Highlighted(
//                    @SerialName("name")
//                    val name: String? = "",
//                    @SerialName("path")
//                    val path: String? = ""
//                )
//            }
//
//            @Serializable
//            data class ReleaseDate(
//                @SerialName("coming_soon")
//                val comingSoon: Boolean? = false,
//                @SerialName("date")
//                val date: String? = ""
//            )
//
//            @Serializable
//            data class SupportInfo(
//                @SerialName("url")
//                val url: String? = "",
//                @SerialName("email")
//                val email: String? = ""
//            )
//
//            @Serializable
//            data class ContentDescriptors(
//                @SerialName("ids")
//                val ids: List<Int?>? = listOf(),
//                @SerialName("notes")
//                val notes: String? = ""
//            )
//        }
//    }
//}