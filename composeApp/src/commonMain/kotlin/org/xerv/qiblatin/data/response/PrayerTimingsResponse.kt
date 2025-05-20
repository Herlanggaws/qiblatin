package org.xerv.qiblatin.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PrayerTimingsResponse(
    @SerialName("Fajr") val fajr: String,
    @SerialName("Sunrise") val sunrise: String,
    @SerialName("Dhuhr") val dhuhr: String,
    @SerialName("Asr") val asr: String,
    @SerialName("Sunset") val sunset: String,
    @SerialName("Maghrib") val maghrib: String,
    @SerialName("Isha") val isha: String,
    @SerialName("Imsak") val imsak: String,
    @SerialName("Midnight") val midnight: String,
    @SerialName("Firstthird") val firstthird: String,
    @SerialName("Lastthird") val lastthird: String
)
